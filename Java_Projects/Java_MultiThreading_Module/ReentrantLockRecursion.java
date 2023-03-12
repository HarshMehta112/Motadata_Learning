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

            System.out.print(lock.getHoldCount()+" ");

            ans = (n) * (factorial(n - 1));

            System.out.print(lock.getHoldCount()+" ");

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
        System.out.println(new ReentrantLockRecursion().factorial(5));
    }

}
