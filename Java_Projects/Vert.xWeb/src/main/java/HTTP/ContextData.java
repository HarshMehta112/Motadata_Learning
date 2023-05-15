package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class ContextData extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/some/path").handler(context->
        {
           context.response().setChunked(true);

           context.response().write("putting values in context object");

           context.put("Name","Harsh");

           context.response().end();

           context.next();
        });

        router.route("/some/path/other").handler(context->
        {
            context.response().setChunked(true);

           context.response().write("I am in context data 2");

//           String name = context.get("Name");

            String data = context.data().toString();

           context.response().write("I am from handler 2 "+ data);

           context.response().end();
        });

        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("Server started listening on port no 8080");
           }
           else
           {
               System.out.println("Some error occurred "+ready.cause().getMessage());
           }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(ContextData.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("Verticle deployed successfully");
            }
            else
            {
                System.out.println("Vertilce not deployed yet ");

                System.out.println("some error occurred "+handler.cause().getMessage());
            }
        });
    }

}
