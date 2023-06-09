import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;


@ServerEndpoint("/endpoint")
public class PushSocket
{
    List<Session> sessionManager = Collections.synchronizedList(new ArrayList<Session>());

    @OnOpen
    public void handleOpen (Session session)
    {

        try
        {
            sessionManager.add(session);
            System.out.println("Client has connected to the server....");
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    @OnMessage
    public String handleMessage (final Session session, String message) throws IOException
    {
        System.out.println("From Client to server : " + message);
        for(Session sessions: sessionManager){
            sessions.getBasicRemote().sendText(message);
        }

//        System.out.println("Sending to the Client : " + message + " From the Server");
        return message + "FromServer";
    }

    @OnClose
    public void handleClose (Session session)
    {
        sessionManager.remove(session);
        System.out.println("Client is now disconnected....");
    }

    @OnError
    public void handleError (Throwable throwable)
    {
        throwable.printStackTrace();
    }

}