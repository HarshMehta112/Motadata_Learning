package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class VirtualHost extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route().virtualHost("https://www.google.com/").handler(context->
        {
            System.out.println("I am in virtual host");
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

        vertx.deployVerticle(VirtualHost.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("Verticle deployed successfully");
            }
            else
            {
                System.out.println("Verticle not deployed");
            }
        });
    }

}
