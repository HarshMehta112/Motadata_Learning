package BufferWriting;

import io.vertx.core.Vertx;


public class Main
{

    public static void main (String[] args)
    {
        final Vertx vertx = Vertx.vertx();
        try
        {
            vertx.deployVerticle(Sender.class.getName());

            vertx.deployVerticle(Receiver.class.getName());
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
//            vertx.close();
        }
    }

}
