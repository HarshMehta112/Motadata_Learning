package MultipleTopicsFromSingleConsumer;

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

            int cnt=50;

            while ( cnt>0 )
            {
                String message1 = "This is Harsh Mehta " + cnt;

                String message2 = "This is Harsh" + cnt;

                producer.produce("1",(message1.getBytes()));

                producer.produce("2",(message2).getBytes());

                System.out.println(message1);

                System.out.println(message2);

//                System.out.println(nsqConfig.getMsgTimeout());

                cnt--;


//                System.err.println(message);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
