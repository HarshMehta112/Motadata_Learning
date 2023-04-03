import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/endpoint")
public class WebSocketClass
{
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
    public String handleMessage (String message)
    {

        System.out.println("From Client to server : " + message);
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