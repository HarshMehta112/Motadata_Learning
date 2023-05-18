package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TimeoutHandler;


public class TimeoutHandlers extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/harsh").handler(TimeoutHandler.create(5000)).handler(context->
        {
            context.response().setChunked(true);

            context.response().end("Hello Harsh !");
        });

        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("Server started listening on 8080");
               startPromise.complete();
           }
           else
           {
               startPromise.fail("some error occurred "+ready.cause().getMessage());
           }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(TimeoutHandlers.class.getName());
    }

}
