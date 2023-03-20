package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PingUtility
{

    private static String status="";

    private static double RTT;

    private static String packetLoss = "" ;

    private static String time="";


    public String getStatus()
    {
        return status;
    }

    public double getRTT()
    {
        return RTT;
    }

    public String getPacketLoss()
    {
        return packetLoss;
    }
    public String getTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();

        return (dtf.format(now));
    }



    public void Ping(String IPAdress)
    {
        PingUtility ping_command = new PingUtility();

        Runtime runtime = null;

        BufferedReader inputReader = null;

        try
        {

            String pingCmd = "ping -c 3 -w 5 " + IPAdress;

            runtime = Runtime.getRuntime();

            Process commandExec = runtime.exec(pingCmd);

            inputReader = new BufferedReader(new InputStreamReader(commandExec.getInputStream()));

            String pingResult = "";

            if(runtime == null)
            {
                throw new NullPointerException();
            }

            String inputLine="";

            while ((inputLine = inputReader.readLine()) != null)
            {

                pingResult += inputLine + "\n";

//                System.out.println(inputLine);

            }

//            System.out.println(pingResult);

            if (pingResult.trim().isEmpty() || !(pingResult.contains("rtt min/avg/max/mdev")))
            {
                status = "Down";

                RTT = 0.0F;

                packetLoss = "100%";

                return;

            }

            else
            {
                String[] splited_by_hyphen = pingResult.split("---");

                String[] splited_by_line = splited_by_hyphen[2].split("\n");

                String[] splited_by_comma = splited_by_line[1].split(",");

//                System.out.println("\n");

//                System.out.println("Status :- Host ( "+ IPAdress +" ) is Reachable");

                status = "Up";

                if(splited_by_hyphen[2] != null)
                {

                    RTT = Double.parseDouble(splited_by_line[2].split("/")[4].trim());

//                    System.out.println(splited_by_line[2].split("/")[4].trim());

//                    System.out.println("RTT Minimum value is :- " + splited_by_line[2].split("/")[3].split("=")[1].trim());
//
//                    System.out.println("RTT Average value is :- " + splited_by_line[2].split("/")[4].trim());
//
//                    System.out.println("RTT Maximum value is :- " + splited_by_line[2].split("/")[5].trim());
                }

//                if(splited_by_comma[0] != null)
//                {
//                    System.out.println("Total Packets Transmitted :- " + splited_by_comma[0].trim().split(" ")[0]);
//                }
//
//                if(splited_by_comma[1] != null)
//                {
//                    System.out.println("Total Packets Received :- " + splited_by_comma[1].trim().split(" ")[0]);
//                }

                if(splited_by_comma[2] != null)
                {
//                    System.out.println("Total Packets Loss :- " + splited_by_comma[2].trim().split(" ")[0]);

                    packetLoss = splited_by_comma[2].trim().split(" ")[0];

                    int packetLossinInt = Integer.parseInt(splited_by_comma[2].trim().split(" ")[0].trim().replace("%",""));

//                    System.out.println(packetLossinInt);

                    if(packetLossinInt>50)
                    {
                        status = "Down";
                    }
                }
            }

        }
        catch (Exception e) //generic exception
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if(inputReader==null)
                {
                    inputReader.close();
                }
            }
            catch (IOException e)
            {
                System.out.println("Buffer reader doesn't close");

                e.printStackTrace();
            }

        }

    }
}
