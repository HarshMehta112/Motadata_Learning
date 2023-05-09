package Timer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;


public class PeriodicTimer extends AbstractVerticle
{
    static int count = 0;

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(PeriodicTimer.class.getName());
    }

    public void start()
    {
        vertx.setPeriodic(1000,res->{
            System.out.println(count++);
        });
    }


}
