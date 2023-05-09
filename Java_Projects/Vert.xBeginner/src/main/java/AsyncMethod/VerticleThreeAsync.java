package AsyncMethod;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;


public class VerticleThreeAsync extends AbstractVerticle
{

    public void start (Promise< Void > startPromise)
    {
        System.out.println("Started with 3------" + deploymentID());

        startPromise.complete();
    }

    public void stop (Promise<Void> promise)
    {
        System.out.println("Stopped with 3----------" + deploymentID());
        promise.complete();
    }

}
