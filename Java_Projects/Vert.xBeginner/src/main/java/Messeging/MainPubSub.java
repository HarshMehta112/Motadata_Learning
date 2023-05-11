package Messeging;

import io.vertx.core.Vertx;


public class MainPubSub
{

    public static void main (String[] args) throws InterruptedException
    {

        Vertx vertx = Vertx.vertx();

//        Thread.sleep(5000);


        vertx.deployVerticle(PublishSubscribePublicer.class.getName()).onComplete(event->{
            if(event.succeeded())
            {
                System.out.println("messages sent successfully");
            }
            else
            {
                System.out.println("Messages have some problems"+event.cause().getMessage());
            }
        });


        vertx.deployVerticle(PublishSubscribeSubscriber.class.getName()).onComplete(handler -> {
            if (handler.succeeded())
            {
                System.out.println("messages receive successfully");
            }
            else
            {
                System.out.println("Some Issue occured!" + handler.cause().getMessage());
            }
        });

    }

}
