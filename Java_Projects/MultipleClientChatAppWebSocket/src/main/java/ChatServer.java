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

    private static ConcurrentHashMap< String, Session > clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen (Session session)
    {
        System.out.println(session.getId());
        clients.put(session.getId(), session);
    }

    @OnMessage
    public void onMessage (String message, Session senderSession) throws IOException
    {

        String[] parts = message.split(":");

        String recipient = parts[0];

        String text = parts[1];

        Session recipientSession = clients.get(recipient);

        if ( recipientSession != null && recipientSession.isOpen() )
        {
            recipientSession.getBasicRemote().sendText(text);
        }
        else
        {
            senderSession.getBasicRemote().sendText("Recipient " + recipient + " not found");
        }
    }

    @OnClose
    public void onClose (Session session)
    {
        clients.remove(session.getId());
    }

}
