package MultipleChannels;

import com.github.brainlag.nsq.NSQProducer;


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

                producer.produce("TestByHarsh",(message.getBytes()));

                System.out.println(message);
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
