package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;


public class Sender extends AbstractVerticle
{

    public void start ()
    {
        EventBus eventBus = vertx.eventBus();

        vertx.setPeriodic(3000,event->
        {
           eventBus.request("Harsh.Test.RequestResponse",
                   "Hello All, I am Harsh Mehta",
                   new DeliveryOptions().setSendTimeout(3000),
                   response-> {
              if( response.succeeded() )
              {
                  System.out.println("result: "+response.result().body());
              }
              else
              {
                  System.out.println("no response");
              }
           });
        });


    }
}
