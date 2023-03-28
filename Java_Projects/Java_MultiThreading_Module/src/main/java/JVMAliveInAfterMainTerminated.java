public class JVMAliveInAfterMainTerminated
{

    public static void main (String[] args) throws InterruptedException
    {

//        Runnable runnable = () ->
//        {
//            while (true) {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//
//        Thread thread = new Thread(runnable, "Harsh");
//        thread.start();  // threAd scheduler


//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);

//        }
        while ( true )
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
    }

}
