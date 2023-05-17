package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class ErrorHandling extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/some/path").handler(context->
        {
           context.response().setChunked(true);

           throw new RuntimeException();
        });

        router.route().failureHandler(context->
        {
            System.out.println(context.statusCode());
        });

        server.requestHandler(router).listen(8080).onComplete(handler->
        {
           if(handler.succeeded())
           {
               System.out.println("Server started listening on the port no 8080");

               startPromise.complete();
           }
           else
           {
               System.out.println("some error occurred "+handler.cause().getMessage());

               startPromise.fail("Some error occurred "+handler.cause().getMessage());
           }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(ErrorHandling.class.getName());
    }

}
