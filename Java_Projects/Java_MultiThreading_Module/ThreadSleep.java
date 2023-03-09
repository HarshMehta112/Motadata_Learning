public class ThreadSleep
{
    public static void main(String[] args) {

        Runnable runnable =()->
        {
            System.out.println(Thread.currentThread().getName()+" running");

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println("finished");

        };

        Thread thread = new Thread(runnable,"harsh");
        thread.start();


    }
}
