package VerticleTree;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;


public class VerticleTwo extends AbstractVerticle
{

    public void start(Promise<Void> startPromise)
    {
        System.out.println("Starting(2) deployment-id: "+deploymentID());

        vertx.deployVerticle(new VerticleThree());

        vertx.deployVerticle(new VerticleThree());

        startPromise.complete();
    }

    public void stop()
    {
        System.out.println("Stopping(2) deployment-id: "+deploymentID());
    }

}
