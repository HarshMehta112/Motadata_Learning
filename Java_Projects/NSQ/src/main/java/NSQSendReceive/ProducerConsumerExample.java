package NSQSendReceive;

import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class ProducerConsumerExample
{

    public static void main (String[] args) throws IOException, NSQException, TimeoutException
    {
        // Initialize the NSQ producer and consumer
        NSQProducer producer = new NSQProducer().addAddress("localhost", 4150).start();
        NSQConsumer consumer = new NSQConsumer(( NSQLookup ) producer, "topic", "channel", (message) ->
        {
            // Consume the message here
            System.out.println("Received message: " + message);
        });

        NSQLookup lookup = new DefaultNSQLookup();

        lookup.addLookupAddress("localhost",4150);

        // Start consuming messages
        consumer.start();

        // Produce messages
        for ( int i = 0; i < 10; i++ )
        {
            String message = "Message " + i;
            producer.produce("topic", message.getBytes());
            System.out.println("Produced message: " + message);
        }

        // Stop the consumer and producer
        consumer.close();
        producer.shutdown();
    }

}

