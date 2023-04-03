import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/chat")
public class ChatServer
{

//    private static ConcurrentHashMap< String, Session > clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen (Session session)
    {
        System.out.println(session.getId());
//        clients.put(session.getId(), session);
    }

    @OnMessage
    public void onMessage (String message, Session session) throws IOException
    {
        Ping.ip = message;

        Ping.session = session;

        Ping.main(new String[]{});
    }

    @OnClose
    public void onClose (Session session)
    {
//        clients.remove(session.getId());
    }

}
