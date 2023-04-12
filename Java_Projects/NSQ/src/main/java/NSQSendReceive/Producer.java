package NSQSendReceive;

import com.github.brainlag.nsq.NSQCommand;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQProducer;

import java.util.Random;


public class Producer
{

    public static void main (String[] args)
    {

        NSQProducer producer = new NSQProducer();

        producer.addAddress("localhost",4150);

        try
        {
            producer.start();

//            Random random = new Random();

            int cnt=0;

            while ( true )
            {
                String message = "This is Harsh Mehta " + cnt;

                cnt++;

                producer.produce("TestFOrr",(message.getBytes()));

                System.out.println(message);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
