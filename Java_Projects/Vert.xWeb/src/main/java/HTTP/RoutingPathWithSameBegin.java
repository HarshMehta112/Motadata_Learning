package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


public class RoutingPathWithSameBegin extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route route = router.route("/get/details/*");

        route.handler(context->
        {
            context.response().setChunked(true);

           context.response().write("Hello Harsh !");

           context.response().end();
        });

        server.requestHandler(router).listen(8080).onComplete(Handler->
        {
            if(Handler.succeeded())
            {
                System.out.println("server stated listening on port no 8080");

                startPromise.complete();
            }
            else
            {
                startPromise.fail("Some error occurred"+Handler.cause().getMessage());
            }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(RoutingPathWithSameBegin.class.getName()).onComplete(ready->
        {
            if(ready.succeeded())
            {
                System.out.println("Verticle deploy successfully");
            }
            else
            {
                System.out.println("verticle not deploy");
            }
        });
    }

}
