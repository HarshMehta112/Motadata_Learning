
import com.github.brainlag.nsq.NSQProducer;

import javax.websocket.Session;


public class Producer
{
    static NSQProducer producer = new NSQProducer();

//    producer.start();

    public static void ProduceMessage (String message, Session session)
    {
        producer.addAddress("localhost",4150);

        try
        {

            producer.produce("TestByHarshPingFunction", (message.getBytes()));

            session.getBasicRemote().sendText("pinging :" + message);


        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }


}