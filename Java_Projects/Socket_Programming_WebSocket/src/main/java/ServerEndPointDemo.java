import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

//@WebSocket(maxIdleTime = Integer.MAX_VALUE)
@ServerEndpoint("/endpoint")
public class ServerEndPointDemo
{
    @OnOpen()
    public void handleOpen(Session session)
    {
        session.setMaxIdleTimeout(300000);
        System.out.println("Client is now connected...");
    }

    @OnMessage
    public String handleMessage(String message)
    {

        System.out.println("receive from client :- "+message);

        String replyMessage = "Echo "+message;

        System.out.println("send to client "+replyMessage);

        return replyMessage;
    }

    @OnClose
    public void handleClose()
    {
        System.out.println("Client is now disconnected");
    }

    @OnError
    public void handleError(Throwable exception)
    {
        exception.printStackTrace();
    }

}
