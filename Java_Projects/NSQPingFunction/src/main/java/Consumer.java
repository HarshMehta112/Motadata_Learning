import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Consumer
{

    Consumer()
    {
        NSQLookup nsqLookup = new DefaultNSQLookup();

        nsqLookup.addLookupAddress("localhost",4161);

        NSQConsumer consumer = new NSQConsumer(nsqLookup,"TestByHarshPingFunction","CHANNELFORPING",(nsqMessage ->
        {
            String msg = new String(nsqMessage.getMessage());

            PingMetric.pingIP(msg);

            System.out.println(msg);

            nsqMessage.finished();
        }));

        ExecutorService service = Executors.newFixedThreadPool(16);

        consumer.setExecutor(service);

        consumer.start();

    }

}
