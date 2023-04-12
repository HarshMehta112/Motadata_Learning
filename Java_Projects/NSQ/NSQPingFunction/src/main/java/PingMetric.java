import javax.websocket.Session;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

class PingMetric
{
    static String IPAddress ="";

    public static final String ANSI_CYAN_BOLD_BRIGHT = "\033[1;96m";

    public static final String ANSI_RESET = "\u001B[0m";


    PingMetric(String IPAdress)
    {
        PingMetric.IPAddress = IPAdress;

    }

    void pingIP()
    {
        PingMetric pingCommand = new PingMetric(IPAddress);

        try
        {
            if(pingCommand == null)
            {
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e)
        {
            System.out.println(e);
        }

        Runtime runtime = null;

        BufferedReader inputReader = null;

        try
        {

            String pingCmd = "ping -c 3 -w 10 " + IPAddress;

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
            }


            if (pingResult.trim().isEmpty())
            {
                System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Name or service not known otherwise Temporary failure in name resolution"+ANSI_RESET);
            }

            else if (!(pingResult.contains("rtt min/avg/max/mdev")))
            {
                System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Status (" +IPAddress+ ") :- Destination Host Unreachable"+ANSI_RESET);
            }

            else
            {
                String[] splited_by_hyphen = pingResult.split("---");

                String[] splited_by_line = splited_by_hyphen[2].split("\n");

                String[] splited_by_comma = splited_by_line[1].split(",");

                System.out.println("\n");

                System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Status (" +IPAddress+ ") :- Host is Reachable"+ANSI_RESET);

                if(splited_by_hyphen[2] != null)
                {
                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"RTT Minimum value is :- " + splited_by_line[2].split("/")[3].split("=")[1].trim()+ANSI_RESET);

                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"RTT Average value is :- " + splited_by_line[2].split("/")[4].trim()+ANSI_RESET);

                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"RTT Maximum value is :- " + splited_by_line[2].split("/")[5].trim()+ANSI_RESET);
                }

                if(splited_by_comma[0] != null)
                {
                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Total Packets Transmitted :- " + splited_by_comma[0].trim().split(" ")[0]+ANSI_RESET);
                }

                if(splited_by_comma[1] != null)
                {
                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Total Packets Received :- " + splited_by_comma[1].trim().split(" ")[0]+ANSI_RESET);
                }

                if(splited_by_comma[2] != null)
                {
                    System.out.println(ANSI_CYAN_BOLD_BRIGHT+"Total Packets Loss :- " + splited_by_comma[2].trim().split(" ")[0]+ANSI_RESET);
                }
            }

        }
        catch (Exception exception)
        {
            System.out.println(exception);
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

                System.out.println(e);
            }

        }

    }
}