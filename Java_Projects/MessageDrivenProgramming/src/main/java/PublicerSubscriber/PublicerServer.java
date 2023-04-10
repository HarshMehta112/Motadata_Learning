package PublicerSubscriber;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;


public class PublicerServer
{

    public static void main (String[] args)
    {
        try( ZContext context = new ZContext(); ZMQ.Socket socket = context.createSocket(SocketType.PUB))
        {
            socket.bind("tcp://*:9999");

            Random random = new Random();

            while ( true )
            {
                String message = "Hi harsh " + random.nextInt(1000);

                socket.send(message);

                socket.send("Harsh");

                Thread.sleep(1000);
            }
        }
        catch ( Exception exception)
        {
            exception.printStackTrace();
        }
    }

}
