import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class Verticle1 extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        var server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/*").handler(context->
        {
            System.out.println("server 1");
        });

        server.requestHandler(router).listen(8080).onSuccess(context->
        {
            System.out.println("server 1 okay with verticle 1");
        });

        startPromise.complete();
    }
}
