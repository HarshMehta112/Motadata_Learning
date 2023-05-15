package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;


public class ClientAcceptMime extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/some/path").consumes("/application/json").produces("text/plain").respond(context->
        {
            System.out.println("Hello I am in consumes(\"/application/json\").produces(\"text/plain\") ");

            return Future.succeededFuture("Hello from text/plain");
        });

        router.route("/some/path").consumes("application/json").produces("application/json").respond(context->
        {
            System.out.println("Hello I am in consumes(\"application/json\").produces(\"application/json\")");

           return Future.succeededFuture(new JsonObject().put("Name","Harsh"));
        });

        router.route("/hash").consumes("application/json").produces("text/plain").respond(context->
        {
            System.out.println(context.getAcceptableContentType());

//            return Future.succeededFuture("Hello from text/plain");

            context.response().putHeader("Content-Type","text/plain");

            return Future.succeededFuture(new JsonObject().put("Surname","Mehta"));

        });


        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("Server started listening on port no 8080");

               startPromise.complete();
           }
           else
           {
               startPromise.fail("Some error occurred "+ready.cause().getMessage());
           }
        });


    }

    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(ClientAcceptMime.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("verticle deployed successfully");
            }
            else
            {
                System.out.println("Verticle not deployed");
            }
        });
    }

}
