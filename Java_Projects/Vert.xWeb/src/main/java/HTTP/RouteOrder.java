package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class RouteOrder extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/harsh").order(1).handler(context->
        {
           context.response().write("Hello World from Route 1\n");

           context.next();
        });

        router.route("/harsh").order(0).handler(context->
        {
            context.response().setChunked(true);

           context.response().write("Hello world from Route 2\n");

           context.next();
        });

        router.route("/harsh").handler(context->
        {

           context.response().write("Hello world from Route 3\n");

           context.response().end();
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

        vertx.deployVerticle(RouteOrder.class.getName());
    }



}