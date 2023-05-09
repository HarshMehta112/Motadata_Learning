package AsyncMethod;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;


public class VerticleTwoAsync extends AbstractVerticle
{
    public void start(Promise<Void> startPromise)
    {

        System.out.println("Strted with 2-------------"+deploymentID());

//        vertx.deployVerticle(new VerticleThreeAsync()).compose(res->vertx.deployVerticle(new VerticleThreeAsync()));

        vertx.deployVerticle(VerticleThreeAsync.class.getName(), new DeploymentOptions().setInstances(4)).onComplete(ready->{
            System.out.println("On complete called!");
            if(ready.succeeded()){
                System.out.println("succeeded!");
                startPromise.complete();
            }else{
                startPromise.fail(ready.cause().getMessage());
            }
        });
    }

    public void stop(Promise<Void> promise)
    {
        System.out.println("Stopped with 2 ----------"+deploymentID());
        promise.complete();
    }

}
