package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.core.file.FileSystem;


public class HelperFunctions extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        FileSystem fileSystem = vertx.fileSystem();

        router.get("/get/image").handler(context->
        {
           context.attachment("DB.jpg");

           fileSystem.readFile("/home/harsh/DB.jpg",handler->
           {
               if(handler.succeeded())
               {
                   context.end(handler.result());
               }
               else
               {
                   context.end("Failed to load the file");
               }
           });

        });

        router.get("/redirect").handler(context->
        {
            System.out.println("I am in redirect");

           context.redirect("https://www.google.com/");

//           context.redirect("back");
        });

        router.get("/check/type").handler(context->
        {
            System.out.println(context.is("application/json"));

            context.json(new JsonObject().put("ans", context.is("text/plain")));
        });


        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if( ready.succeeded() )
           {
               System.out.println("server started listening on 0808");

               startPromise.complete();
           }
           else
           {
               System.out.println("some error occurred "+ready.cause().getMessage());

               startPromise.fail("some error occurred "+ready.cause().getMessage());
           }
        });


    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(HelperFunctions.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("verticle deployed successfully");
            }
            else
            {
                System.out.println("verticle not deploy4ed yet");

                System.out.println(handler.cause().getMessage());
            }
        });
    }

}
