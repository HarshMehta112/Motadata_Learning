public class DaemonThreadFlagTrue
{
    static Runnable runnable = ()->
    {
        while (true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" Runningg");
        }
    };

    public static void main(String[] args) {

        Thread thread = new Thread( runnable,"Harsh" );
        thread.setDaemon(true);
        thread.start();
        try
        {
            thread.sleep(3100);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
//        Thread t = new Thread.ofVirtual().start.(runnable);
        System.out.println(Thread.currentThread().getName()+" "+ Thread.currentThread().getState());

    }


}
