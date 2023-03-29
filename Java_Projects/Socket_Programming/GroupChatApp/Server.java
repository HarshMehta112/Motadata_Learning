package GroupChatApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{

    private ServerSocket serverSocket;

    public Server (ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
    }

    public void startServer()
    {
        try
        {
            while ( ! serverSocket.isClosed() )
            {
                System.out.println("Trying to connect>>>");

                Socket socket = serverSocket.accept();

                System.out.println("Connected..");

                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);

                thread.start();
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

    public void closeServer()
    {
        try
        {
                if(serverSocket!=null)
                {
                    serverSocket.close();
                }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }


    public static void main (String[] args)
    {

        try
        {
            ServerSocket serverSocket = new ServerSocket(1616);

            Server server = new Server(serverSocket);

            server.startServer();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }


    }

}
