import java.io.*;
import java.net.Socket;


class Client
{

    static DataInputStream din = null;

    static DataOutputStream dout = null;

    static BufferedReader bufferedReader=null;

    static Socket socket=null;

    public static void main (String[] args)
    {

        try
        {
            socket = new Socket("127.0.0.1", 1616);

            din = new DataInputStream(socket.getInputStream());

            dout = new DataOutputStream(socket.getOutputStream());

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "";

            String msgout = "";

            while ( ! msgin.equals("bye") )
            {
                System.out.println("Connection established>>");

                msgout = bufferedReader.readLine();

                dout.writeUTF(msgout);

                msgin = din.readUTF();

                System.out.println(msgin);

//                dout.flush();
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
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