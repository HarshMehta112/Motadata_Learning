import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;


@ServerEndpoint("/endpoint")
public class PushSocket
{

    List< Session > socketSessions = Collections.synchronizedList(new ArrayList< Session >());

    @OnOpen
    public void handleOpen (Session session)
    {

        try
        {
            System.out.println("Client has connected to the server....");
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    @OnMessage
    public String handleMessage (Session session, String message)
    {

        System.out.println("From Client to server : " + message);

        TimerTask timerTask = new TimerTask()
        {

            @Override
            public void run ()
            {

                try
                {
                    session.getBasicRemote().sendText("Hello Harsh");
                }
                catch ( IOException ex )
                {
                    ex.printStackTrace();
                }
            }
        };

        Timer timer = new Timer(true);

        timer.scheduleAtFixedRate(timerTask, 0, 5000);

        System.out.println("Sending to the Client : " + message + " From the Server");
        return message + "FromServer";
    }

    @OnClose
    public void handleClose ()
    {

        System.out.println("Client is now disconnected....");
    }

    @OnError
    public void handleError (Throwable throwable)
    {

        throwable.printStackTrace();
    }

}