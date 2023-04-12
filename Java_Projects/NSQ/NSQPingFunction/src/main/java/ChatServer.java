import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/endpoint")
public class ChatServer
{

    private Session session;

    @OnOpen
    public void onOpen (Session session)
    {
        System.out.println(session.getId());
    }

    @OnMessage
    public void onMessage (String message, Session session) throws IOException
    {
        PingMetric.IPAddress = message;

        this.session = session;

        new Producer();
        new Consumer();
    }

    @OnClose
    public void onClose (Session session)
    {

    }

}
