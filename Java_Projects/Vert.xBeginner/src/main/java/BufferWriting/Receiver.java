package BufferWriting;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;

import static io.vertx.core.Vertx.vertx;


public class Receiver extends AbstractVerticle
{
    public void start()
    {

        EventBus eventBus = getVertx().eventBus();

        eventBus.consumer("get-buffer",buff->
        {
            Buffer buffer = (Buffer)buff.body();

            System.out.println("From Handler 1----------------"+buffer.getInt(0));
        });

        eventBus.consumer("get-buffer",buff->
        {
            Buffer buffer = (Buffer)buff.body();

            System.out.println("From Handler 2----------------"+buffer.getInt(0));
        });


    }

}
