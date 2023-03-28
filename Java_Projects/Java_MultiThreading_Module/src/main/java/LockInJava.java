import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;


public class LockInJava
{

    private Lock lock = new ReentrantLock();

    private Condition conditionMet = lock.newCondition();

    public void method1 ()
    {

        lock.lock();

        try
        {
            conditionMet.await();
        }
        catch ( InterruptedException e )
        {
            System.out.println(e);
        }
        finally
        {
            lock.unlock();
        }
    }

    public void method2 ()
    {

        lock.lock();

        try
        {
            conditionMet.signal();
        }
        catch ( Exception e )
        {
            System.out.println(e);
        }
        finally
        {
            lock.unlock();
        }
    }


}


class LockTest
{

    public static void main (String[] args)
    {

        LockInJava obj = new LockInJava();

        obj.method1();

        obj.method2();


    }

}
