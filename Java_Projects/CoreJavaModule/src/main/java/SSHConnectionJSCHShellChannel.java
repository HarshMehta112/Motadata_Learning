import java.io.*;

import com.jcraft.jsch.Channel;

import com.jcraft.jsch.JSch;

import com.jcraft.jsch.Session;

public class SSHConnectionJSCHShellChannel
{

    private static String ip_address;

    private static String user_name;

    private static String user_password;

    private static String command;

    public void setData() throws IOException
    {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter IP address to connect");

        ip_address = "10.20.40.197"; //bfr.readLine();

        System.out.println("Enter user name to connect");

        user_name = "nikunj"; //bfr.readLine();

        System.out.println("Enter user password to connect");

        user_password = "Mind@123"; //bfr.readLine();

        System.out.println("Enter command to run");

        command = "ps "; //bfr.readLine();

    }

    public static void main(String[] args) throws IOException {

        SSHConnectionJSCHShellChannel ssh = new SSHConnectionJSCHShellChannel();

        BufferedReader bReader = null;

        if(ssh != null)
        {
            ssh.setData();
        }

        try
        {
            java.util.Properties config = new java.util.Properties();

            if(config != null)
            {
                config.put("StrictHostKeyChecking", "no");
            }

            JSch jsch = new JSch();

            if(jsch != null)
            {
                Session session = jsch.getSession(user_name, ip_address, 1267);

                if(session != null)
                {
                    session.setPassword(user_password);

                    session.setConfig(config);

                    session.connect();
                }

                System.out.println("Connected to the Remote PC ");

                Channel channel = session.openChannel("shell");

                OutputStream inputstream_for_the_channel = channel.getOutputStream();

                PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

                channel.setOutputStream(System.out, true);

                channel.connect();

                System.out.print("No of Context Interrupts per Seconds");

                commander.println("vmstat ");

                System.out.print("Total used memory in MB");

                commander.println("free");

                System.out.print("Total number of cores");

                commander.println("nproc");

                System.out.print("CPU utilization at user level int %");

                commander.println("mpstate ");

                System.out.print("Total no of transfers per sec");

                commander.println("iostat");

                commander.println("exit");

                commander.close();

                do
                {
                    Thread.sleep(1000);
                }
                while(!channel.isEOF());

                session.disconnect();

            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        finally
        {
            try
            {
                if(bReader==null)
                {
//                    bReader.close();
                }
            }
            catch (Exception e)
            {
                System.out.println("Buffer reader doesn't close");

                System.out.println(e);
            }
        }
    }
}