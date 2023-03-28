public class ThreadPriorities extends Thread
{
    @Override
    public void run()
    {
        for(int index=0;index<=4;index++)
        {
            System.out.println(Thread.currentThread().getName()+" "+index);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

//        System.out.println("Priority of child thread is "+ Thread.currentThread().getPriority());
    }

    public static void main(String[] args)
    {
        ThreadPriorities thread = new ThreadPriorities();

//        thread.setPriority(10);
//
//        thread.setPriority(NORM_PRIORITY);
//
//        thread.setPriority(MIN_PRIORITY);
//
        thread.setPriority(MAX_PRIORITY);

        thread.start();

        Thread.yield();

        ThreadPriorities thread1 = new ThreadPriorities();

        thread1.start();

        System.out.println(Thread.currentThread().getPriority());

    }


}
