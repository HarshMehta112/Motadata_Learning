package PushPullBuddyTask;

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

        for(int index=1;index<=5;index++)
        {
            final int threadId=index;

            Thread thread = new Thread(new Runnable()
            {

                @Override
                public void run ()
                {
                    Socket socket = context.createSocket(ZMQ.PULL);

                    try
                    {

                        var isConnected = socket.connect("tcp://*:6000");


                        if ( isConnected )
                        {
                            System.out.println("Client " +threadId+ " connected");
                        }
                        else
                        {
                            System.out.println("Client not connected");
                        }

                        System.out.println("Server worker Thread --> "+threadId +" "+ new String(socket.recv()));

//                        System.out.println("This will execute....");

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
            },"worker"+threadId);
            thread.start();
        }
    }

}