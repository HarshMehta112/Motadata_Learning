import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class DatagramClient
{
    DatagramClient() throws IOException
    {

        BufferedReader readerKeyBoard = new BufferedReader(new InputStreamReader(System.in));

        InetAddress IP = InetAddress.getByName("localhost");

        DatagramSocket clientSocket = new DatagramSocket(1616);

        while(true)
        {
            byte[] sendBuffer;

            byte[] receiveBuffer = new byte[1024];

            System.out.print("\nclient :- ");

            String clientData = readerKeyBoard.readLine();

            sendBuffer = clientData.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,IP,999);

            clientSocket.send(sendPacket);

            if(clientData.equalsIgnoreCase("bye"))
            {
                System.out.println("Connection Terminated by client");

                break;
            }

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);

            clientSocket.receive(receivePacket);

            String serverData = new String(receivePacket.getData());

            System.out.println("\nServer :- "+ serverData);


        }

        clientSocket.close();

    }

    public static void main (String[] args) throws IOException
    {
        new DatagramClient();
    }


}
