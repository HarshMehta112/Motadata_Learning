package MultipleTopicsFromSingleConsumer;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;


public class Consumer
{
    public static void main (String[] args)
    {

        NSQLookup nsqLookup = new DefaultNSQLookup();

        nsqLookup.addLookupAddress("localhost",4161);

        NSQConsumer consumer1 = new NSQConsumer(nsqLookup,"1","C1",(nsqMessage ->
        {
            String msg = new String(nsqMessage.getMessage());

            System.out.println(msg);

            nsqMessage.finished();

        }));

        NSQConsumer consumer2 = new NSQConsumer(nsqLookup,"2","C2",(nsqMessage ->
        {
            String msg = new String(nsqMessage.getMessage());

            System.err.println(msg);

            nsqMessage.finished();
        }));


        consumer1.start();

        consumer2.start();
    }

}
