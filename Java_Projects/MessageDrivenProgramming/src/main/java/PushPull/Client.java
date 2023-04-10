package PushPull;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;


/**
 * bind() and connect() both will work fine with client side
 * Client will only be able to receive messages.
 * When client will try to send message, program will throw "UnsupportedOperationException"
 */

public class Client
{

    public static void main (String[] args)
    {
        ZContext context = new ZContext();

        Socket socket = context.createSocket(ZMQ.PULL);

        try
        {

            var isConnected = socket.connect("tcp://*:6000");


            if ( isConnected )
            {
                System.out.println("Client connected");
            }
            else
            {
                System.out.println("Client not connected");
            }

            System.out.println("Server: " + new String(socket.recv()));

            System.out.println("This will execute....");

        }
        catch ( Exception exception )
        {
            System.out.println("Exception: " + exception);

            exception.printStackTrace();
        }
        finally
        {
            socket.close();
            System.out.println("Closed");
        }
    }

}