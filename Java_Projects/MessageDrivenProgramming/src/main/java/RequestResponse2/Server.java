package RequestResponse2;


import org.zeromq.SocketType;
import org.zeromq.ZContext;


public class Server
{

    public static void main (String[] args)
    {

        try
        {
            var context = new ZContext();

            var socket = context.createSocket(SocketType.REP);

            var isBind = socket.bind("tcp://*:5555");

            if ( isBind )
            {
                System.out.println("Bind successful");
            }
            else
            {
                System.out.println("Bind not successful");
            }

            byte[] receivedByte = socket.recv();

            System.out.println("Received: " + new String(receivedByte));

            socket.send("Hey client, your message is received.");


        }
        catch ( Exception exception )
        {
            System.out.println("Exception: " + exception);

            exception.printStackTrace();
        }
    }

}
