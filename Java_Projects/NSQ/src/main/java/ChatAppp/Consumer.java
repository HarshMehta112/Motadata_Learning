package ChatAppp;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Consumer
{

    public static void main (String[] args)
    {
        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                NSQProducer producer = new NSQProducer();

                producer.addAddress("localhost",4150);

                try
                {
                    producer.start();

                    while ( true )
                    {

                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                        String message= reader.readLine();

                        producer.produce("TestByHarshForChatApp",(message.getBytes()));

                        System.out.println(message);
                    }
                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                NSQLookup nsqLookup = new DefaultNSQLookup();

                nsqLookup.addLookupAddress("localhost",4161);

                NSQConsumer consumer1 = new NSQConsumer(nsqLookup,"TestByHarsh","CHANNELFORCHATAPPPCONSUMER",(nsqMessage ->
                {
                    String msg = new String(nsqMessage.getMessage());

                    System.out.println(msg);

                    nsqMessage.finished();
                }));

                consumer1.start();
            }
        }).start();

    }

}
