package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;


public class PointToPointSender extends AbstractVerticle
{
    public void start ()
    {
        EventBus eventBus = vertx.eventBus();

        JsonObject object  = new JsonObject().put("harsh", "mehta");

        vertx.setPeriodic(3000,event->
        {
            eventBus.send("Harsh.Test.PointToPoint",
                    object,
                    new DeliveryOptions().setSendTimeout(3000));
        });


    }
}
