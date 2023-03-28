import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockRecursion
{

    ReentrantLock lock = new ReentrantLock();

    public int factorial (int n)
    {

        int ans = 0;

        if ( n == 0 )
        {
            return ans = 1;
        }
        else
        {
            lock.lock();

            System.out.println(Thread.currentThread().getName()+" - "+lock.getHoldCount()+" ");

            ans = (n) * (factorial(n - 1));

//            System.out.print(Thread.currentThread().getName()+" - "+lock.getHoldCount()+" ");

//            if(lock.getHoldCount()==3)
//            {
//                lock.unlock();
//            }

            lock.unlock();
        }
        return ans;
    }

    public static void main (String[] args)
    {
        ReentrantLockRecursion reentrantLock = new ReentrantLockRecursion();

        Thread hread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                System.out.println(reentrantLock.factorial(5));

            }
        });

        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {

                System.out.println(reentrantLock.factorial(5));

            }
        });

        hread.start();

        thread.start();
    }

}
