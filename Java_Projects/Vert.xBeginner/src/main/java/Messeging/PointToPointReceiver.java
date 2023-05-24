package Messeging;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;


public class PointToPointReceiver extends AbstractVerticle
{
    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new PointToPointSender());

        vertx.deployVerticle(new PointToPointReceiver());
    }

    public void start()
    {


        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("Harsh.Test.PointToPoint", stringMessage -> {

            System.out.println(stringMessage.body());

            stringMessage.reply("Hello Harsh! How are you?");

        });
    }
}
