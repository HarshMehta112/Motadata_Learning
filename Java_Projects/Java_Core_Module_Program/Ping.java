import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

class Ping
{
    public String setIpAddress() throws IOException
    {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter IP address to Ping");

        String ipAddress = bReader.readLine();

        return ipAddress;
    }


    public static void main(String[] args)
    {
        Ping ping_command = new Ping();

        if(ping_command == null)
        {
            throw new NullPointerException();
        }

        String ipAddress="";

        Runtime runtime = null;

        BufferedReader inputReader = null;

        try
        {
            ipAddress = ping_command.setIpAddress();

            String pingCmd = "ping -c 3 -w 10 " + ipAddress;

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

                System.out.println(inputLine);

            }

            System.out.println(pingResult);

            if (pingResult.trim().isEmpty())
            {
                System.out.println("Name or service not known otherwise Temporary failure in name resolution");
            }

            else if (!(pingResult.contains("rtt min/avg/max/mdev")))
            {
                System.out.println("Status :- Destination Host Unreachable");
            }

            else
            {
                String[] splited = pingResult.split("---");

                String[] splited1 = splited[2].split("\n");

                String[] splited2 = splited1[1].split(",");

                System.out.println("\n");

                System.out.println("Status :- Host is Reachable");

                if(splited[2] != null)
                {
                    System.out.println("RTT Minimum value is :- " + splited1[2].split("/")[3].split("=")[1].trim());

                    System.out.println("RTT Average value is :- " + splited1[2].split("/")[4].trim());

                    System.out.println("RTT Maximum value is :- " + splited1[2].split("/")[5].trim());
                }

                if(splited2[0] != null)
                {
                    System.out.println("Total Packets Transmitted :- " + splited2[0].trim().split(" ")[0]);
                }

                if(splited2[1] != null)
                {
                    System.out.println("Total Packets Received :- " + splited2[1].trim().split(" ")[0]);
                }

                if(splited2[2] != null)
                {
                    System.out.println("Total Packets Loss :- " + splited2[2].trim().split(" ")[0]);
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Inside the IO Exception");

            System.out.println(e);
        }
        catch (NullPointerException e)
        {
            System.out.println("Inside the Null Pointer exception");

            System.out.println(e);
        }

        finally
        {
            try
            {
                inputReader.close();
            }
            catch (IOException e)
            {
                System.out.println("Buffer reader doesn't close");

                System.out.println(e);
            }

        }

    }
}