package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class PathParameters extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.post("/employee/get/:empID").handler(context->
        {
           String epmId = context.pathParam("empID");

            System.out.println(epmId);

           context.response().setChunked(true);

           context.response().write("Welcome "+epmId);

           context.response().end();
        });

        router.get("/employee/get/:empID").respond(context->
        {
           String empID = context.pathParam("empID");

           return Future.succeededFuture("welcome "+empID);
        });

        router.get("/employee/get/:empID/:dep").respond(context->
        {
            String empID = context.pathParam("empID");

            String department = context.pathParam("dep");

            System.out.println(empID);

            System.out.println(department);

            return Future.succeededFuture("Welcome " + empID + "...." + department);
        });

        server.requestHandler(router).listen(8080).onComplete(event->
        {
           if(event.succeeded())
           {
               System.out.println("Server staretd listening on port no 8080");

               startPromise.complete();
           }
           else
           {
               startPromise.fail("Some inernal error occurred"+event.cause().getMessage());
           }
        });

    }


    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(PathParameters.class.getName());
    }

}
