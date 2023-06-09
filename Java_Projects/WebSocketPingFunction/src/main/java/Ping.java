import javax.websocket.Session;
import java.io.IOException;
import java.net.InetAddress;


public class Ping
{
    static Session session;
    static String ip;
    public Ping(Session session, String ip)
    {
        this.ip = ip;

        this.session = session;
    }

    public static void pingResult (String ip, Session session)
    {

        boolean reachable = false;
        try
        {
            InetAddress address = InetAddress.getByName(ip);

            reachable = address.isReachable(5000);

            Thread.sleep(10000);

            if(reachable )
            {
                session.getBasicRemote().sendText("IP = "+ip+ " address is reachable");
            }
            else
            {
                session.getBasicRemote().sendText("IP = "+ip + " address is not reachable");
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( InterruptedException e )
        {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                pingResult(ip,session);
            }
        });
        thread.start();
    }

}