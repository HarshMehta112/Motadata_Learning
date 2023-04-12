package NSQSendReceive;

import com.github.brainlag.nsq.NSQConfig;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Consumer
{

    public static void main (String[] args)
    {

        NSQConfig nsqConfig  = new NSQConfig();

//        nsqConfig.setMaxInFlight(1);

        NSQLookup nsqLookup = new DefaultNSQLookup();

        nsqLookup.addLookupAddress("localhost",4161);

        NSQConsumer consumer = new NSQConsumer(nsqLookup,"TestFOrr","CHANNEL",(nsqMessage ->
        {
            String msg = new String(nsqMessage.getMessage());

            System.out.println(msg + " : "+ Thread.currentThread().getName());



            try
            {
                Thread.sleep(5000);

                System.out.println("-------------------------------------------------------------------");
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException(e);
            }

            nsqMessage.finished();
        }));

        ExecutorService service = Executors.newFixedThreadPool(16);

        consumer.setExecutor(service);
        consumer.start();
    }

}
