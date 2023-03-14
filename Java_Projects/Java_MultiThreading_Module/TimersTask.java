import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimersTask
{

    public static void main (String[] args)
    {
        TimerTask task = new TimerTask()
        {

            public void run ()
            {

                System.out.println("Task performed on: " + new Date() + " " + "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;

        timer.schedule(task, 0,1000);
    }

}
