
import com.github.brainlag.nsq.NSQProducer;


public class Producer
{

    Producer ()
    {

        NSQProducer producer = new NSQProducer();

        producer.addAddress("localhost", 4150);

        try
        {
            producer.start();

            String message = PingMetric.IPAddress;

            producer.produce("TestByHarshPingFunction", (message.getBytes()));

            System.out.println(message);

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}