package GroupChatApp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client
{

    private Socket socket;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private String name;

    Client (Socket socket, String name)
    {

        try
        {
            this.socket = socket;

            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            this.name = name;
        }
        catch ( Exception exception )
        {
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void sendMessage ()
    {

        try
        {
            bufferedWriter.write(name);

            bufferedWriter.newLine();

            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);

            while ( socket.isConnected() )
            {
                String message = scanner.nextLine();

                bufferedWriter.write(name + " :- " + message);

                bufferedWriter.newLine();

                bufferedWriter.flush();
            }

        }
        catch ( Exception exception )
        {
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void listenMessgae()
    {
        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                String messageFromGrp;

                try
                {
                    while(socket.isConnected())
                    {
                        messageFromGrp = bufferedReader.readLine();

                        System.out.println(messageFromGrp);
                    }
                }
                catch ( Exception exception )
                {
                    closeEverything(socket,bufferedReader,bufferedWriter);
                }
            }
        },"listenThreads").start();
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

    public static void main (String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");

        String name = scanner.nextLine();

        Socket socket = new Socket("localhost",1616);

        Client client = new Client(socket,name);

        client.listenMessgae();

        client.sendMessage();
    }


}
