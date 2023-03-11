//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class ProducerConsumerBlockingQueue
//{
//    public static void main(String[] args)
//    {
//        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);
//
//        final Runnable producer = () -> {
//            while(true)
//            {
//                queue.put(createItem()); //Thread blocks here if queueu is full
//            }
//    };
//
//        new Thread(producer.start());
//        new Thread(producer.start());
//
//        final Runnable consumer = () ->
//        {
//            while (true)
//            {
//                Item item = queue.take();  // thread blocks here if queueu is empty
//                process(i);
//            }
//        }
//
//        new Thread(consumer.start());
//        new Thread(consumer.start());
//
//    }
//}
