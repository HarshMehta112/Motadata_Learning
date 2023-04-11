package RequestResponse;


import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Receiver
{
    public static void main(String[] args)
    {
        try (ZContext context = new ZContext(); ZMQ.Socket socket = context.createSocket(SocketType.REP))
        {
            socket.connect("tcp://localhost:5555");

            socket.setSndHWM(2);

            while ( true )
            {
                System.out.println("Sender: "+new String(socket.recv()));

                System.out.println("Sending message...!");

                socket.send("Message received...");

                Thread.sleep(1000);
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}