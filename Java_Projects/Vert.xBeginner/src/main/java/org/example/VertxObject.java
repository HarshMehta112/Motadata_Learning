package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

public class VertxObject extends AbstractVerticle
{

    public static void main (String[] args) throws InterruptedException
    {

        System.out.println(Thread.activeCount());

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle("Harsh")
                .onComplete(res -> {

                    System.out.println(vertx.getClass());

                    if (res.succeeded()) {
                        System.out.println("Deployment id is: " + res.result());
                    } else {
                        System.out.println("Deployment failed!");
                    }
                });

        System.out.println(Thread.activeCount());
    }

    public void start(){

        System.out.println("Inside vertical");
    }

}
