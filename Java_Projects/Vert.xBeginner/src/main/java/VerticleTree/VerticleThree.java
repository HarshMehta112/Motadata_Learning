package VerticleTree;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;


public class VerticleThree extends AbstractVerticle
{

    public void start (Promise< Void > startPromise)
    {
        System.out.println("Starting(3) deployment-id: " + deploymentID());

        startPromise.complete();
    }

    public void stop ()
    {
        System.out.println("Stopping(3) deployment-id: " + deploymentID());
    }

}