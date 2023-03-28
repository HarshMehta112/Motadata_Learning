import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockExample extends Thread
{

    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main (String[] args)
    {

//        thread runnable = new thread();

        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    lock.lock();

                    System.out.println(lock.isHeldByCurrentThread());

                    System.out.println(Thread.currentThread().getName() + " is in lock");

                }
                finally
                {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    lock.lock();

                    System.out.println(lock.isHeldByCurrentThread());

                    System.out.println(Thread.currentThread().getName() + " is in lock");

                }
                finally
                {
                    lock.unlock();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                try
                {
                    lock.lock();

                    System.out.println(lock.isHeldByCurrentThread());

                    System.out.println(Thread.currentThread().getName() + " is in lock");

                }
                finally
                {
                    lock.unlock();
                }
            }
        });

        thread1.start();

        System.out.println(lock.isHeldByCurrentThread()+"\n" + "i am in main");

        thread2.start();

        System.out.println(lock.isHeldByCurrentThread()+"\n" + "i am in main");

        thread3.start();

        System.out.println(lock.isHeldByCurrentThread()+"\n" + "i am in main");


    }

}
