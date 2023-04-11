package ExclusivePair;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;


public class Client
{

    public static void main (String[] args)
    {

        try ( ZContext context = new ZContext() )
        {
            // Create two sockets with exclusive pair pattern
            ZMQ.Socket socketSend = context.createSocket(SocketType.PAIR);

            ZMQ.Socket socketReceive = context.createSocket(SocketType.PAIR);

            // Bind socketSend to an endpoint
            socketSend.bind("tcp://*:5556");

            // Connect socketReceive to the same endpoint
            socketReceive.connect("tcp://localhost:5555");

            socketSend.send("This is Harsh from Client side");

            System.out.println("Message sent from client side...!");

            System.out.println("Receiver: "+new String(socketSend.recv()));

        }
    }



}
