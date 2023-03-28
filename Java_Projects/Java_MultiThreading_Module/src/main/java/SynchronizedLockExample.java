import java.util.concurrent.locks.ReentrantLock;


public class SynchronizedLockExample
{

    private ReentrantLock lock = new ReentrantLock();

    String S;

    synchronized void disp()
    {
//        lock.lock();

        S = "Hi i am in disp";

        System.out.println(S+" "+Thread.currentThread().getName());

       disp2();

    }

    synchronized void disp2()
    {
        S = "I am in disp 2";

        System.out.println(S+" "+Thread.currentThread().getName());

//        lock.unlock();

    }




    public static void main (String[] args)
    {
        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                new SynchronizedLockExample().disp();
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                new SynchronizedLockExample().disp2();
            }
        });

        thread2.start();

        thread1.start();

//        thread2.start();

    }

}
