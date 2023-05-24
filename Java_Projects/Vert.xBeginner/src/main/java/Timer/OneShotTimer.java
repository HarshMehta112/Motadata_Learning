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

    public void start () throws InterruptedException
    {

       long id = vertx.setTimer(1000, res ->
        {
            vertx.fileSystem().createFile("Harsh.txt");
        });
//
//       vertx.cancelTimer(id);

        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            for (int j = 0 ; j < Integer.MAX_VALUE; j++)
            {
                for(int x=0;x<Integer.MAX_VALUE;x++)
                {
                    System.out.println("thread in the while loop : " + Thread.currentThread().getName());

                    System.out.println(" Start method completed");
                }
            }
        }
    }

    public void stop ()
    {

        vertx.undeploy(OneShotTimer.class.getName());

        System.out.println("Undeploying the verticle");
    }

}
