package NSQSendReceive;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.ServerAddress;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.Set;


public class Consumer
{

    public static void main (String[] args)
    {
        NSQLookup nsqLookup = new DefaultNSQLookup();

        nsqLookup.addLookupAddress("localhost",4161);

        NSQConsumer consumer = new NSQConsumer(nsqLookup,"TestByHarsh","CHANNEL",(nsqMessage ->
        {
            String msg = new String(nsqMessage.getMessage());

            System.out.println(msg);

            nsqMessage.finished();
        }));


        consumer.start();
    }

}
