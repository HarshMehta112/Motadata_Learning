package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;


public class PublishSubscribePublicer extends AbstractVerticle
{

    public void start()
    {

        EventBus eventBus = vertx.eventBus();

        vertx.setPeriodic(1000,id->{
            eventBus.request("Harsh.Test.PublishSubscribe","Hello all !", new DeliveryOptions().setSendTimeout(1000));
        });
    }

}
