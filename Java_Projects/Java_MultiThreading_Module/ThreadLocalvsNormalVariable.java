
class MyyRunnable implements Runnable
{

    ThreadLocal<Integer> threadLocal = new ThreadLocal()
    {

        @Override
        protected Object initialValue ()
        {

            return 0;
        }
    };

    @Override
    public void run ()
    {
        for(int index=0;index<=5;index++)
        {
            threadLocal.set(index);

            System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
        }

    }

}

public class ThreadLocalvsNormalVariable
{

    public static void main (String[] args)
    {
        MyyRunnable runnable = new MyyRunnable();

        Thread thread = new Thread(runnable,"thread--1");

        Thread thread1 = new Thread(runnable,"thread--2");

        thread.start();

        thread1.start();

        try
        {
            thread.join();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

}
