import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;


class Server
{
    static Socket socket=null;

    static ServerSocket serverSocket=null;

    static DataInputStream din=null;

    static DataOutputStream dout=null;

    static BufferedReader bufferedReader=null;

    public static void main (String[] args)
    {
        try
        {
            serverSocket = new ServerSocket(1616);

            socket = serverSocket.accept();

            din = new DataInputStream(socket.getInputStream());

            dout = new DataOutputStream(socket.getOutputStream());

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String msgin="";

            String msgout= "";

            while ( !msgin.equals("bye") )
            {
                msgin = din.readUTF();

                System.out.println(msgin);

                msgout = bufferedReader.readLine();

                dout.writeUTF(msgout);

                dout.flush();
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        finally
        {
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
}