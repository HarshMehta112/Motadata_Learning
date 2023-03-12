import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.concurrent.LinkedBlockingQueue;


public class SingleThreadedPing
{

    int noOfIPs;
    public LinkedBlockingQueue setIpAddress ()
    {

        LinkedBlockingQueue< String > listOfIPs = new LinkedBlockingQueue<>();

        try
        {

            System.out.println("Enter the number of IPs want to ping  ");

            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

            noOfIPs = Integer.parseInt(bReader.readLine());

            for ( int index = 0; index < noOfIPs; index++ )
            {
                System.out.println("Enter "+(index+1)+" IP address to Ping");

                String ipAddress = bReader.readLine();

                listOfIPs.put(ipAddress);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }

        return listOfIPs;
    }


    public StringBuilder pingUtility (String ipAddress)
    {

        Runtime runtime = null;

        BufferedReader inputReader = null;

        StringBuilder pingMatric = new StringBuilder();


        try
        {

            String pingCmd = "ping -c 3 " + ipAddress;

            runtime = Runtime.getRuntime();

            Process commandExec = runtime.exec(pingCmd);

            inputReader = new BufferedReader(new InputStreamReader(commandExec.getInputStream()));

            String pingResult = "";

            if ( runtime == null )
            {
                throw new NullPointerException();
            }

            String inputLine = "";

            while ( (inputLine = inputReader.readLine()) != null )
            {

                pingResult += inputLine + "\n";

//                System.out.println(inputLine);

            }

//            System.out.println(pingResult);

            if ( pingResult.trim().isEmpty() )
            {
                pingMatric.append(ipAddress+" Name or service not known otherwise Temporary failure in name resolution");

                pingMatric.append("\n");
            }
            else if ( ! (pingResult.contains("rtt min/avg/max/mdev")) )
            {
                pingMatric.append("Status :- Destination (" + ipAddress + ") Host Unreachable");

                pingMatric.append("\n");
            }
            else
            {
                String[] splited_by_hyphen = pingResult.split("---");

                String[] splited_by_line = splited_by_hyphen[2].split("\n");

                String[] splited_by_comma = splited_by_line[1].split(",");

                System.out.println("\n");

                pingMatric.append("Status :- Host (" + ipAddress + ") is Reachable");

                pingMatric.append("\n");

                if ( splited_by_hyphen[2] != null )
                {
                    pingMatric.append("RTT Minimum value is :- ").append(splited_by_line[2].split("/")[3].split("=")[1].trim());

                    pingMatric.append("\n");

                    pingMatric.append("RTT Average value is :- ").append(splited_by_line[2].split("/")[4].trim());

                    pingMatric.append("\n");

                    pingMatric.append("RTT Maximum value is :- ").append(splited_by_line[2].split("/")[5].trim());

                    pingMatric.append("\n");
                }

                if ( splited_by_comma[0] != null )
                {
                    pingMatric.append("Total Packets Transmitted :- ").append(splited_by_comma[0].trim().split(" ")[0]);

                    pingMatric.append("\n");
                }

                if ( splited_by_comma[1] != null )
                {
                    pingMatric.append("Total Packets Received :- " ).append(splited_by_comma[1].trim().split(" ")[0]);

                    pingMatric.append("\n");
                }

                if ( splited_by_comma[2] != null )
                {
                    pingMatric.append("Total Packets Loss :- ").append(splited_by_comma[2].trim().split(" ")[0]);

                    pingMatric.append("\n");
                }
            }

            System.out.println(Thread.currentThread().getName());

        }
        catch ( Exception e ) //generic exception
        {
            System.out.println(e);
        }

        finally
        {
            try
            {
                if ( inputReader == null )
                {
                    inputReader.close();
                }
            }
            catch ( IOException e )
            {
                System.out.println("Buffer reader doesn't close");

                System.out.println(e);
            }

        }
        return pingMatric;
    }

}