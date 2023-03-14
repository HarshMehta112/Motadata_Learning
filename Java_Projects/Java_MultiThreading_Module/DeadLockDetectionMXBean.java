import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadLockDetectionMXBean
{


    static public void detectDeadlocks ()
    {

        ThreadMXBean threadmxbean = ManagementFactory.getThreadMXBean();

        long[] threadIds = threadmxbean.findDeadlockedThreads();

        boolean deadlock = threadIds != null && threadIds.length > 0;

        System.out.println(threadIds);
    }


    public static void main (String[] args)
    {

        final String resource1 = "ratan jaiswal";

        final String resource2 = "vimal jaiswal";
        Thread t1 = new Thread()
        {

            public void run ()
            {

                synchronized ( resource1 )
                {
                    System.out.println("Thread 1: locked resource 1");

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch ( Exception e )
                    {
                    }

                    synchronized ( resource2 )
                    {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };


        Thread t2 = new Thread()
        {

            public void run ()
            {

                synchronized ( resource2 )
                {
                    System.out.println("Thread 2: locked resource 2");

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch ( Exception e )
                    {
                    }

                    synchronized ( resource1 )
                    {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };


        t1.start();

        t2.start();

        DeadLockDetectionMXBean.detectDeadlocks();
    }

}

