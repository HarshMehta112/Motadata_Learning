import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class MyRunnablee implements Runnable
{

    private String ipaddress = null;

    MyRunnablee (String ipaddress)
    {

        this.ipaddress = ipaddress;
    }

    SingleThreadedPing obj = new SingleThreadedPing();

    @Override
    public void run ()
    {

        StringBuilder s = new StringBuilder(obj.pingUtility(ipaddress));


        System.out.println(" " + s);
    }

}


public class Every5SecDifferentIPs
{

    public String setIpAddress () throws IOException
    {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter IP address to Ping");

        return bReader.readLine();
    }

    public void pingUtility (String ipAddress)
    {

        Runtime runtime = null;

        BufferedReader inputReader = null;

//        System.out.println(ipAddress);

        try
        {

            String pingCmd = "ping -c 3 " + ipAddress;

//            System.out.println(ipAddress);

            runtime = Runtime.getRuntime();

            Process commandExec = runtime.exec(pingCmd);

            inputReader = new BufferedReader(new InputStreamReader(commandExec.getInputStream()));

            String pingResult = "";

            String inputLine = "";

            while ( (inputLine = inputReader.readLine()) != null )
            {

                pingResult += inputLine + "\n";

//                System.out.println(inputLine);

            }

//            System.out.println(pingResult);

            if ( pingResult.trim().isEmpty() )
            {
                System.out.println("Name or service not known otherwise Temporary failure in name resolution");
            }

            else if ( ! (pingResult.contains("rtt min/avg/max/mdev")) )
            {
                System.out.println("Status :- Destination Host Unreachable");
            }

            else
            {
                String[] splited_by_hyphen = pingResult.split("---");

                String[] splited_by_line = splited_by_hyphen[2].split("\n");

                String[] splited_by_comma = splited_by_line[1].split(",");

                System.out.println("\n");

                System.out.println("Status :- Host is Reachable");

                if ( splited_by_hyphen[2] != null )
                {
                    System.out.println("RTT Minimum value is :- " + splited_by_line[2].split("/")[3].split("=")[1].trim());

                    System.out.println("RTT Average value is :- " + splited_by_line[2].split("/")[4].trim());

                    System.out.println("RTT Maximum value is :- " + splited_by_line[2].split("/")[5].trim());
                }

                if ( splited_by_comma[0] != null )
                {
                    System.out.println("Total Packets Transmitted :- " + splited_by_comma[0].trim().split(" ")[0]);
                }

                if ( splited_by_comma[1] != null )
                {
                    System.out.println("Total Packets Received :- " + splited_by_comma[1].trim().split(" ")[0]);
                }

                if ( splited_by_comma[2] != null )
                {
                    System.out.println("Total Packets Loss :- " + splited_by_comma[2].trim().split(" ")[0]);
                }
            }

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

    }

    public static void main (String[] args) throws IOException, InterruptedException
    {

        int noOfIPs = 0;

        LinkedBlockingQueue< String > listOfIPs = new LinkedBlockingQueue<>();

        SingleThreadedPing pingObject = new SingleThreadedPing();

        System.out.println("Enter the number of IPs want to ping  ");

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        noOfIPs = Integer.parseInt(bReader.readLine());

        ScheduledExecutorService exce = Executors.newScheduledThreadPool(4);

        for ( int index = 0; index < noOfIPs; index++ )
        {
            System.out.println("Enter " + (index + 1) + " IP address to Ping");

            String ipAddress = bReader.readLine();

            listOfIPs.put(ipAddress);

            exce.scheduleAtFixedRate(new MyRunnablee(( String ) listOfIPs.peek()), 0, 3, TimeUnit.SECONDS);
        }
//        exce.shutdown();

        while ( ! exce.isTerminated() )
        {

        }

        System.out.println("Finish all the threads");

    }

}
