public class ThreadJoinMethod
{

    static Runnable runnable = () ->
    {
        for ( int i = 0; i < 5; i++ )
        {
            try
            {
                Thread.sleep(1000);
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        }
    };

    public static void main (String[] args)
    {

        Thread thread = new Thread(runnable, "Harsh");

        thread.setDaemon(true);

        thread.start();

        try
        {
            thread.join();
        }
        catch ( InterruptedException e )
        {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

//        System.out.println("hi");

    }

}
