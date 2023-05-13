package Timer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;


public class OneShotTimer extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        System.out.println("Deploying the Verticle");

        vertx.deployVerticle(OneShotTimer.class.getName());
    }

    public void start ()
    {

        vertx.setTimer(4000, res ->
        {
            System.out.println("thread in the timer : " + Thread.currentThread().getName());

            System.out.println("Execution running");
        });

        while ( true )
        {
            System.out.println("thread in the while loop : " + Thread.currentThread().getName());

            System.out.println(" Start method completed");
        }
    }

    public void stop ()
    {

        vertx.undeploy(OneShotTimer.class.getName());

        System.out.println("Undeploying the verticle");
    }

}
