package VerticleTree;

import AsyncMethod.VerticleMainAsync;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;


public class VerticleMain extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VerticleMain()).onComplete(stringAsyncResult -> {
            System.out.println(stringAsyncResult);

            vertx.undeploy(stringAsyncResult.result()).onComplete(voidAsyncResult -> {
                System.out.println(voidAsyncResult);

                vertx.close();
            });
        });
    }
    public void start(Promise<Void> startPromise){

        System.out.println("Starting(1) deployment id: "+deploymentID());

        vertx.deployVerticle(new VerticleTwo());

        vertx.deployVerticle(new VerticleTwo());

        startPromise.complete();
    }

    public void stop(){
        System.out.println("Stopping(1) deployment-id: "+deploymentID());
    }
}
