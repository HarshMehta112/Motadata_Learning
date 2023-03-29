import java.io.*;
import java.net.Socket;


public class MultiThreadedClient
{

    Socket socket;

    BufferedReader breaderKeyboard = new BufferedReader(new InputStreamReader(System.in));

    BufferedReader bufferedReader;

    PrintWriter out;

    String msgin, msgout;

    MultiThreadedClient ()
    {

        try
        {
            socket = new Socket("localhost", 1616);

            System.out.println("Connecting......");

            if ( ! socket.isClosed() )
            {
                System.out.println("Connected to the sever");

                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(), true);

                readMessage();

                writeMessage();
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }

    }

    void readMessage ()
    {

        Thread thread = new Thread(() ->
        {

            while ( true )
            {
                System.out.print(">> ");

                try
                {
                    msgin = breaderKeyboard.readLine();

                    out.println(msgin);

                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }, "ReadThread");

        thread.start();

    }

    void writeMessage () throws IOException
    {

        Thread thread = new Thread(() ->
        {
            boolean check = true;

            while ( check  )
            {
                System.out.print(">> ");

                try
                {
                    msgout = bufferedReader.readLine();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }

                System.out.println(" Server :- " + msgout);

                if(msgout==null )
                {
                    System.exit(0);
                }

                if ( msgout.equalsIgnoreCase("bye") )
                {
                    check = false;

                    try
                    {
                        socket.close();
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                }
            }
        }, "writeThread");

        thread.start();

    }


    public static void main (String[] args)
    {
        new MultiThreadedClient();
    }

}


