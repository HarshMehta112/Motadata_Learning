package PublicerSubscriber;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;


public class Subscriber
{

    public static void main (String[] args)
    {
        try( ZContext context = new ZContext(); ZMQ.Socket socket = context.createSocket(SocketType.SUB))
        {
            socket.connect("tcp://localhost:9999");

            String filter = (args.length > 0) ? args[0] : "Hi ";

//            socket.subscribe("");

            socket.subscribe(filter.getBytes(ZMQ.CHARSET));

            while ( true )
            {
                String mess = socket.recvStr();

                System.out.println(mess);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
