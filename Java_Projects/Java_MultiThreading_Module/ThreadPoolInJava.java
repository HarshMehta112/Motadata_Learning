import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolInJava implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(Thread.currentThread().getName()+" End");

    }
}

class TestThreadPool
{
    public static void main(String[] args)
    {
        ScheduledExecutorService exce = Executors.newScheduledThreadPool(5);

        for(int index=1;index<=10;index++)
        {
            Runnable runnable = new ThreadPoolInJava();

            exce.scheduleAtFixedRate(runnable,1,5, TimeUnit.SECONDS);
        }
       // exce.shutdown();

        while(!exce.isTerminated()){}

        System.out.println("Finish all the threads");

//        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}