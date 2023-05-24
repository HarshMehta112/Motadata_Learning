package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;

import java.util.concurrent.atomic.AtomicInteger;


public class PublishSubscribePublicer extends AbstractVerticle
{

    public void start()
    {

        EventBus eventBus = vertx.eventBus();

        AtomicInteger count = new AtomicInteger();

        vertx.setPeriodic(1000,id->{
            count.getAndIncrement();
            eventBus.publish("Harsh.Test.PublishSubscribe","Hello all !"+count, new DeliveryOptions().setSendTimeout(1000));
        });
    }

}
