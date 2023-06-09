import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class Main extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);

        router.route("/*").handler(StaticHandler.create().setIndexPage("Discovery.html"));

        vertx.createHttpServer().requestHandler(router)
                .listen(8080).onComplete(httpServerAsyncResult ->
                {
                    if(httpServerAsyncResult.succeeded())
                    {
                        System.out.println("Server started listening");
                        startPromise.complete();
                    }
                    else
                    {
                        startPromise.fail(httpServerAsyncResult.cause().getCause());
                    }
                });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Main.class.getName());
    }

}
