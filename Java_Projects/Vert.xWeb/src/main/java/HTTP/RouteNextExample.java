package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class RouteNextExample extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/get/info").disable().handler(context->
        {
           context.response().setChunked(true);

           context.response().write("Hello from server I am in get/info router 1");

           vertx.setTimer(4000,tid->
           {
              context.next();
           });
        });

        router.get("/get/info").handler(context->
        {
           context.response().end("\nHello from server I am in get/info router 2");
        });

        server.requestHandler(router).listen(8080).onComplete(httpServerAsyncResult ->
        {
            if(httpServerAsyncResult.succeeded())
            {
                System.out.println("Server satrted listening");

                startPromise.complete();
            }
            else
            {
                System.out.println("Some error occurred");

                startPromise.fail("Some error occured"+httpServerAsyncResult.cause().getMessage());
            }
        });

    }


    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(RouteNextExample.class.getName()).onComplete(handler->
        {
           if(handler.succeeded())
           {
               System.out.println("Deployment successfully");
           }
           else
           {
               System.out.println("deployment unsuccessfully");

               handler.cause().printStackTrace();
           }
        });
    }


}
