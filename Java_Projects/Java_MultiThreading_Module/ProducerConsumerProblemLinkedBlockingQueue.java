import java.util.Random;

import java.util.concurrent.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;


public class ProducerConsumerProblemLinkedBlockingQueue extends Thread
{

    private static BlockingQueue< Integer > queue = new LinkedBlockingQueue<>();

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

        ProducerThread.start();

        ConsumerThread.start();


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

                System.out.println("Size of queue "+queue.size());
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
                Thread.sleep(1000);

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
