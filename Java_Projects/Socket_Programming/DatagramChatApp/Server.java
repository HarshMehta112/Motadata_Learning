package DatagramChatApp;

import java.net.*;
import java.io.*;
import java.util.*;


public class Server
{

    public static void main (String args[]) throws IOException, InterruptedException
    {

        DatagramSocket datagramSocket = new DatagramSocket(1617);

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

                        DatagramPacket sp = new DatagramPacket(bytes, bytes.length, ip, 9998);

                        datagramSocket.send(sp);

                        String msg = new String(bytes);


                        if ( (msg).equals("bye") )
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

                        DatagramPacket sp1 = new DatagramPacket(bytes, bytes.length);

                        datagramSocket.receive(sp1);

                        String msg = (new String(bytes)).trim();

                        System.out.println(" Client :- " + msg);

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