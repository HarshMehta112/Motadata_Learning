//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//public class CountDownLatch
//{
//
//    public static void main (String[] args)
//    {
//
//        ExecutorService service = Executors.newFixedThreadPool(4);
//
//        CountDownLatch latch = new CountDownLatch(3);
//
//        service.submit(new DependentService(latch));
//
//        service.submit(new DependentService(latch));
//
//        service.submit(new DependentService(latch));
//
//        try
//        {
//            latch.wait();
//        }
//        catch ( InterruptedException e )
//        {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("All dependent servivce initiallized");
//
//
//    }
//
//}
//
//
//public static class DependentService implements Runnable
//{
//    private CountDownLatch latch;
//
//    public DependentService(CountDownLatch latch)
//    {
//        this.latch = latch;
//    }
//
//    @Override
//    public void run ()
//    {
//        System.out.println("I am in run method");
//
//        latch.countDown();
//    }
//
//
//
//}