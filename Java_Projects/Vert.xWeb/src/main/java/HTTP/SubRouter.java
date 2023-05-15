package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;


public class SubRouter extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Router employeeEndoints = Router.router(vertx);

        router.route("/employees/*").subRouter(employeeEndoints);

        employeeEndoints.get("/get").handler(context ->
        {
            context.json(new JsonObject().put("message", "List of all employees"));
        });

        employeeEndoints.post("/:emailId").handler(context ->
        {
            System.out.println(context.pathParam("emailId"));

            context.json(new JsonObject().put("message", "Employee Added!").put("emailID",context.pathParam("emailId")));
        });

        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("server started listening port no 8080");

               startPromise.complete();
           }
           else
           {
               System.out.println("Some error occurred "+ready.cause().getMessage());

               startPromise.fail("Some error occurred "+ready.cause().getMessage());
           }
        });

    }

    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(SubRouter.class.getName());
    }

}
