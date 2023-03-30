package GroupChatApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler implements Runnable
{

    public static ArrayList< ClientHandler > clientHandlers = new ArrayList<>();

    private Socket socket;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private String clientName;

    ClientHandler (Socket socket)
    {

        try
        {
            this.socket = socket;

            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            this.clientName = bufferedReader.readLine();

            clientHandlers.add(this);

            broadCastMessage("Server :-" + clientName + " has entered in the chat");
        }
        catch ( Exception exception )
        {
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
    {
        try
        {
            if ( bufferedReader != null )
                bufferedReader.close();

            if ( bufferedWriter != null )
                bufferedWriter.close();

            if ( socket!=null )
                socket.close();
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void run ()
    {

        while ( socket.isConnected() )
        {
            try
            {
                String messgae = bufferedReader.readLine();

                broadCastMessage(messgae);
            }
            catch ( Exception exception )
            {
                closeEverything(socket,bufferedReader,bufferedWriter);

                break;
            }

        }
    }

    public void broadCastMessage(String message)
    {
        for(ClientHandler clientHandler:clientHandlers)
        {
            try
            {
//                System.out.println("Hi");

                if(!clientHandler.clientName.equals(clientName))
                {
                    clientHandler.bufferedWriter.write(message);

//                    System.out.println("hi");

                    clientHandler.bufferedWriter.newLine();   /// Imppppppppppppp

                    clientHandler.bufferedWriter.flush();
                }
            }
            catch ( Exception exception )
            {
                closeEverything(socket,bufferedReader,bufferedWriter);

            }

        }
    }

}
