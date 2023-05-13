package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


public class MultipleHandlers extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route getDetailsRoute = router.route("/get/info");

        Route Sankalp = router.route("/Sam");

        Sankalp.handler(contextsss->
        {
           contextsss.response().setChunked(true);

            System.out.println(Thread.currentThread().getName());

           contextsss.response().write("Harsh Mehta");

           contextsss.response().end();
        });

        getDetailsRoute.handler(context->
        {
            System.out.println(Thread.currentThread().getName());

            context.response().setChunked(true);

           vertx.executeBlocking(promise ->
           {
               System.out.println(Thread.currentThread().getName());

               int i=0;

               String s = null;

              for(i=0;i<1000;i++)
              {
                  s += "Hello world from handler 1\n";
              }
               context.response().write(s);

              context.response().end();

           });

//            context.response().end("Hi");

        });
        server.requestHandler(router).listen(8080).onComplete(event->
        {
            if(event.succeeded())
            {
                System.out.println(Thread.currentThread().getName());
                System.out.println("server listening on port no 8080");

                startPromise.complete();
            }
            else
            {
                System.out.println("some error occurred"+event.cause().getMessage());
            }
        });
    }


    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MultipleHandlers.class.getName());
    }


}
