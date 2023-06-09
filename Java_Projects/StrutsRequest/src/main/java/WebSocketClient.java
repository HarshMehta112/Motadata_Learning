import javax.websocket.*;
import java.net.URI;


@ClientEndpoint
public class WebSocketClient
{

    private Session session;

    private String output;

    @OnMessage
    public void onMessage (String message)
    {

        output = message;
    }

    public void connect (String serverUri)
    {

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try
        {
            container.connectToServer(this, URI.create(serverUri));
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public String getOutput ()
    {

        return output;
    }

    public void setSession (Session session)
    {

        this.session = session;
    }

    public Session getSession ()
    {

        return session;
    }

}
