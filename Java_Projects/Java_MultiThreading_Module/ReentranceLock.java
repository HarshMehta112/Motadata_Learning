import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReentranceLock {

    public static void main (String args[])
    {
        final ThreadTest counter = new ThreadTest();

        Thread t1 = new Thread(counter);

        Thread t2 = new Thread(counter);

        t1.start();

        t2.start();

    }

    static class ThreadTest implements Runnable {

        private final ReentrantLock lock = new ReentrantLock();
        private int count = 0;

        public void run()
        {
            while (true)
            {
                try
                {
                    getCount();

                    Thread.sleep(100);

                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }


        public int getCount()
        {
            lock.lock();

            try
            {
                System.out.println(Thread.currentThread().getName()+" " + count);

                return count++;
            }
            finally
            {
                lock.unlock();
            }
        }

    }
}
