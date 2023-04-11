package MultipleTopics;

import com.github.brainlag.nsq.NSQConfig;
import com.github.brainlag.nsq.NSQProducer;


public class Producer
{

    public static void main (String[] args)
    {

        NSQConfig nsqConfig = new NSQConfig();

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

                producer.produce("TestByHarsh",(message.getBytes()));

//                producer.produce("TestBySankalp",message.getBytes());

                System.out.println(message);

                System.out.println(nsqConfig.getMsgTimeout());


//                System.err.println(message);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
