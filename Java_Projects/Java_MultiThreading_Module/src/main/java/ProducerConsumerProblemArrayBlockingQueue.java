import java.util.Random;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;


public class ProducerConsumerProblemArrayBlockingQueue extends Thread
{

    private static BlockingQueue< Integer > queue = new ArrayBlockingQueue<>(8);

    public static void main (String[] args)
    {

        Thread ProducerThread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    producer();
                    producer();
                    producer();
                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
            }
        });

        Thread ConsumerThread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    consumer();
                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
            }
        });
            
        ConsumerThread.start();

        ProducerThread.start();


    }

    private static void producer ()
    {

        Random random = new Random();

        while ( true )
        {
            try
            {
                Thread.sleep(1000);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

            int produce = random.nextInt(100);

            try
            {
                queue.put(produce);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

            System.out.println("Produced : " + produce);
        }
    }


    private static void consumer ()
    {

        while ( true )
        {
            int consume = 0;

            try
            {
                Thread.sleep(10000);

                consume = queue.take();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }

            System.out.println("Consumed : " + consume);
        }
    }

}
