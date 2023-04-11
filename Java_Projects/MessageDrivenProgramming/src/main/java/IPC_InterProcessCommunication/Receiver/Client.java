package IPC_InterProcessCommunication.Receiver;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;


public class Client
{

    public static void main (String[] args) throws Exception
    {

        String address = "/address";
        System.out.println("CLIENT: Parsed Address: " + address);

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(SocketType.REQ);

        address = "ipc://" + address;
        socket.connect(address);
        System.out.println("CLIENT: Connected to " + address);
        for ( int i = 0; i < 5; i++ )
        {
            socket.send("Ping " + i);
            System.out.println("CLIENT: Sent.");
            String rep = new String(socket.recv());
            System.out.println("Reply " + i + ": " + rep);
        }
        socket.close();
        context.term();
    }

}
