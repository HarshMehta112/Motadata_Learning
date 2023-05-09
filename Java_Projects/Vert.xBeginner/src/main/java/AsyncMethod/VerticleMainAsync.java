package AsyncMethod;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;


public class VerticleMainAsync extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VerticleMainAsync()).onComplete(stringAsyncResult ->
        {

            if(stringAsyncResult.succeeded())
            {
                vertx.undeploy(stringAsyncResult.result()).onComplete(voidAsyncResult ->
                {
                    System.out.println(voidAsyncResult);

                    vertx.close();
                });
            }else{
                System.out.println(stringAsyncResult.cause().getMessage());
            }

        });
    }

    public void start(Promise<Void> startPromise)
    {

        System.out.println("Started with 1 -----------" +deploymentID());

//        vertx.deployVerticle(new VerticleTwoAsync()).compose(res->vertx.deployVerticle(new VerticleTwoAsync()));

        vertx.deployVerticle(VerticleTwoAsync.class.getName(), new DeploymentOptions().setInstances(2)).onComplete(ready->{
            if(ready.succeeded()){
                startPromise.complete();
            }else{
                startPromise.fail(ready.cause().getMessage());
            }
        });

    }

    public void stop(Promise<Void> stopPromise)
    {
        System.out.println("Stopped with 1 -----------"+deploymentID());
        stopPromise.complete();
    }

}

