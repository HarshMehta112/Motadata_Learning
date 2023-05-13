package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;


public class SimpleRouterExample extends AbstractVerticle
{
    public void start()
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route().handler(routingContext ->
        {
            HttpServerResponse response = routingContext.response();

            response.putHeader("content-type","text-plain");

            response.end("Hello all! I am Harsh Mehta");
        });

        server.requestHandler(router).listen(8080);
    }


    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(SimpleRouterExample.class.getName());
    }


}
