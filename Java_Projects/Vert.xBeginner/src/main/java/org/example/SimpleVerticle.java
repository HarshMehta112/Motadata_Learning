package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleVerticle extends AbstractVerticle
{
//      static AtomicInteger count = new AtomicInteger(6);
    public void start(Promise<Void> startPromise)
    {

        AtomicInteger count = new AtomicInteger(6);

        try
        {
            Thread.sleep(20000);  //throws warning
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        vertx.setTimer(4000, id ->

                System.out.println("After 4s, timer id: " + id + "\tDeployment id: " + deploymentID())

        );

        vertx.setPeriodic(3000, id -> {

            System.out.println("Every 3s, timer-id: " + id + "\tDeployment-id: " + deploymentID());

            if (count.decrementAndGet() < 0)
            {
                startPromise.complete();
            }
        });

        System.out.println("Deployment current configuration: " + config());

        startPromise.complete();

    }

    public void stop()
    {
        System.out.println("Cleaning up timers...");
    }

}