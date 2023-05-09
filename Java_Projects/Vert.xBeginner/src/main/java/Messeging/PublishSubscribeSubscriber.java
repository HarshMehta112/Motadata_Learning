package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;


public class PublishSubscribeSubscriber extends AbstractVerticle
{

    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("Harsh.Test.PublishSubscribe", stringMessage -> {

            System.out.println("Subsciber 1 :- "+stringMessage.body());

        });

        eventBus.consumer("Harsh.Test.PublishSubscribe", stringMessage -> {

            System.out.println("Subsciber 2 :- "+stringMessage.body());

        });
    }

}
