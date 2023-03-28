import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

class Pings
{
    private String ipAddress;

    public void setIpAddress() throws IOException
    {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter IP address to Ping");

        ipAddress = bfr.readLine();

        this.ipAddress = ipAddress;
    }

    public String getIpAddress()
    {
        return this.ipAddress;
    }


    public String getPingCommand()
    {
        String command = "ping -c 3 " + getIpAddress();

        return command;
    }


    public static void main(String[] args)
    {
        Pings obj = new Pings();

        try
        {
            obj.setIpAddress();

            Process sysProcess = Runtime.getRuntime().exec(obj.getPingCommand());

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(sysProcess.getInputStream()));

            int pings=3;

            String line;

            while((line = streamReader.readLine()) != null)
            {
                System.out.println(line);

                if(line.startsWith("64 bytes from"))
                {

                }
                //System.out.println(pings);
            }

        }

        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}