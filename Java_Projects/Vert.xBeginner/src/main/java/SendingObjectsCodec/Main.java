package SendingObjectsCodec;

import io.vertx.core.Vertx;


public class Main
{

    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Sender.class.getName());

        vertx.deployVerticle(Receiver.class.getName());

    }

}
