package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class Reroute extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/some/path").handler(context ->
        {
            context.put("Name", "Harsh");

            context.next();
        });

        router.route("/some/path/C").handler(context ->
        {
            System.out.println("---->----->----->" + context.request().params());

            context.json(new Student(1, "Harsh"));

        });

        router.route("/some/path/B").handler(context ->
        {
            System.out.println("---->----->" + context.request().params());

            context.reroute("/some/path/C");
        });

        router.route("/some/path/A").handler(context ->
        {
            System.out.println("---->" + context.request().params());

            context.reroute("/some/path/B");
        });

        router.get("/some/path").handler(context ->
        {
            System.out.println("Params:" + context.request().params());

            System.out.println("Rerouting!!!");

            context.put("Param1", "hello");

            context.reroute("/some/path/A?msg=hellooooooooo");
        });

        server.requestHandler(router).listen(8184).onComplete(ready ->
        {
            if ( ready.succeeded() )
            {
                System.out.println("Successfully stated Listening");

                startPromise.complete();
            }
            else
            {
                System.out.println("Some Issue Occurred!" + ready.cause().getMessage());

                startPromise.fail("Some Issue Occurred!" + ready.cause().getMessage());
            }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Reroute.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("verticle deployed successfully");
            }
            else
            {
                System.out.println("Not deployed yet "+handler.cause().getMessage());
            }
        });
    }

}
