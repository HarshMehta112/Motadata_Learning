package org.example;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class SimpleVerticleExample
{
    public static void main(String[] args)
    {

        Vertx vertx = Vertx.vertx();

        System.out.println(SimpleVerticle.class.getCanonicalName()+"\n"
                +SimpleVerticle.class.getName()+"\n"+SimpleVerticle.class.getSimpleName());

        vertx.deployVerticle(SimpleVerticle.class.getCanonicalName(),
                new DeploymentOptions().setInstances(2),
                res -> {
            if (res.succeeded())
            {
                String id = res.result();

                System.out.println("Main deployment id: "+id);

                vertx.undeploy(id, result -> {

                    if (result.succeeded())
                    {

                        System.out.println("undeployed");

                        vertx.close();

                    }
                    else
                    {
                        System.out.println("Failed to undeploy: ");

                        result.cause().printStackTrace();

                    }
                });
            }
        });
    }
}