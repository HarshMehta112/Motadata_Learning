package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class RouteMIME extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/some/path").consumes("text/plain").respond(context ->
                Future.succeededFuture("Hello From text/plain"));

        router.route("/some/path").consumes("application/json").respond(context -> (
                Future.succeededFuture("Hello from application/json")
//                Future.failedFuture("hello")
        ));

        router.route("/some/path").consumes("text/html").respond(context ->
                Future.succeededFuture("hello from text/html"));

        server.requestHandler(router).listen(8080).onComplete(httpServerAsyncResult ->
        {
            if (httpServerAsyncResult.succeeded()) {
                System.out.println("Server statetd listening on 8080");

                startPromise.complete();
            } else {
                startPromise.fail("Some error occurred " + httpServerAsyncResult.cause().getMessage());
            }
        });
    }


    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(RouteMIME.class.getName()).onComplete(handler ->
        {
            if (handler.succeeded()) {
                System.out.println("Verticle deploy successfully");
            } else {
                System.out.println("verticle not deployed");
            }
        });
    }


}
