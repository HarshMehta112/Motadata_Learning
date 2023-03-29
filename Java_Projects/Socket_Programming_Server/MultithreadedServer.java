import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class MultithreadedServer
{

    ServerSocket serverSocket;

    Socket socket;

    BufferedReader breaderKeyboard = new BufferedReader(new InputStreamReader(System.in));

    BufferedReader bufferedReader;

    PrintWriter out;

    String msgin,msgout;

    MultithreadedServer()
    {
        try
        {
            serverSocket = new ServerSocket(1616);

            System.out.println("Listening on port 1616");

            socket = serverSocket.accept();

            if(socket!=null)
            {
                System.out.println("Connected to server....");

                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(),true);

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
                System.out.println(">>");

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

            while ( check )
            {
                System.out.print(">> ");

                try
                {
                    msgout = bufferedReader.readLine();

                    System.out.println(" Client :- " + msgout);
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }

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
        new MultithreadedServer();
    }


}
