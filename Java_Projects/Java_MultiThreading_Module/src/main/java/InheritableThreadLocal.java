//import java.util.concurrent.atomic.AtomicInteger;
//
//
//class InheritableThread implements Runnable
//{
//
//    ThreadLocal<Integer> parentThreadLoccal = new ThreadLocal()
//    {
//
//        @Override
//        protected Object initialValue ()
//        {
//
//            return 0;
//        }
//    };
//
//    @Override
//    public void run ()
//    {
//        for(int index=0;index<=4;index++)
//        {
//            parentThreadLoccal.set(index);
//
//            System.out.println(Thread.currentThread().getName()+" "+parentThreadLoccal.get());
//        }
//    }
//
//}
//
//public class InheritableThreadLocal
//{
//
//    public static void main (String[] args)
//    {
//        InheritableThread runnable = new InheritableThread();
//
//        Thread thread = new Thread(runnable,"Parent");
//
//        thread.start();
//
//        AtomicInteger
//
//        Thread childThread = new Thread(runnable,"child")
//    }
//
//}
