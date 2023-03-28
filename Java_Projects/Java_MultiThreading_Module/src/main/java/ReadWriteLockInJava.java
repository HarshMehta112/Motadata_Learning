import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
class ReadWriteLockInJava
{
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();

    LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    void set(Object object)
    {
        writeLock.lock();

        try
        {
            queue.put((Integer ) object);

            System.out.println(Thread.currentThread().getName()+" "+queue);
        }
        catch ( InterruptedException e )
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            writeLock.unlock();
        }
    }

    void get()
    {
        readLock.lock();

        try
        {
            queue.peek();

            System.out.println(Thread.currentThread().getName()+" "+queue);

        }
        catch ( Exception e )
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            readLock.unlock();
        }
    }


    public static void main (String[] args) throws InterruptedException
    {
        ReadWriteLockInJava test = new ReadWriteLockInJava();

        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                test.set(2);
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                test.set(3);
            }
        });

        Thread thread4 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                test.get();
            }
        });

        Thread thread5 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                test.get();
            }
        });

//        Thread thread3 = new Thread(new Runnable()
//        {
//
//            @Override
//            public void run ()
//            {
//                test.set(8);
//            }
//        });

//        thread3.start();

        thread1.start();

        thread2.start();

        thread4.start();

        thread5.start();

    }

}