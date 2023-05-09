package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;


public class PointToPointSender extends AbstractVerticle
{
    public void start ()
    {
        EventBus eventBus = vertx.eventBus();

        vertx.setPeriodic(3000,event->
        {
            eventBus.send("Harsh.Test.PointToPoint",
                    "Hello All, I am Harsh Mehta",
                    new DeliveryOptions().setSendTimeout(3000));
        });


    }
}
