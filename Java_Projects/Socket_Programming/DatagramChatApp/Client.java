package DatagramChatApp;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client
{

    public static void main (String args[]) throws IOException
    {

        DatagramSocket datagramSocket = new DatagramSocket(9999);

        InetAddress ip = InetAddress.getByName("localhost");

        Thread sendMessage = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    while ( true )
                    {
                        byte[] bytes = new byte[1000];

                        bytes = reader.readLine().getBytes();

                        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, ip, 1616);

                        datagramSocket.send(datagramPacket);

                        String msg = new String(bytes);

                        if ( msg.equals("bye") )
                        {
                            break;
                        }
                    }

                }
                catch ( IOException e )
                {
                    System.out.println("Exception occurred");
                }
            }
        });


        Thread receiveMessage = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    while ( true )
                    {
                        byte[] bytes = new byte[1000];

                        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

                        datagramSocket.receive(datagramPacket);

                        String msg = (new String(bytes)).trim();

                        System.out.println("Server :-"+msg);

                        if ( msg.equals("bye") )
                        {
                            break;
                        }
                    }
                }
                catch ( Exception e )
                {
                    System.out.println("Exception occurred");
                }
            }
        });

        sendMessage.start();

        receiveMessage.start();
    }

}