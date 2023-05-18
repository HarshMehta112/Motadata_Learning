package HTTP;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.DeploymentOptions;

import io.vertx.core.Promise;

import io.vertx.core.Vertx;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {

    // Whole code will be deployed and ran on same event-loop thread. Also request will be handled on same thread.
    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        System.out.println("Start method thread : "+Thread.currentThread().getName());

        vertx.createHttpServer().requestHandler(req ->
                {
                    req.response().putHeader("content-type", "text/plain").end("Hello from Vert.x!");

                    System.out.println("http request-handler thread : "+Thread.currentThread().getName());

                })
                .listen(8888, http ->
                {
                    if (http.succeeded())
                    {
                        startPromise.complete();

                        System.out.println("HTTP server started on port 8888");
                    }
                    else
                    {
                        startPromise.fail(http.cause());
                    }

                    System.out.println("http server deployment thread : "+Thread.currentThread().getName());
                });
    }

    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MainVerticle.class.getName());
    }
}



