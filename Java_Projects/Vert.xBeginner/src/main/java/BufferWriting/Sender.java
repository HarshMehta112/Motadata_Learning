package BufferWriting;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;

import static io.vertx.core.Vertx.vertx;


public class Sender extends AbstractVerticle
{
    public void start()
    {

        EventBus eventBus = getVertx().eventBus();

        Buffer buffer = Buffer.buffer();

        buffer.appendInt(1000);

        eventBus.send("get-buffer",buffer);
        eventBus.send("get-buffer",buffer);
        eventBus.send("get-buffer",buffer);


        buffer.setInt(0,3000);

        eventBus.send("get-buffer",buffer);

    }


}
