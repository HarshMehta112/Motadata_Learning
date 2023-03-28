public class JavaVolatileKeyword
{
    static volatile int count = 0;

    static void increment()
    {
        count++;
//        synchronized (JavaVolatileKeyword.class)
//        {
//            count++;
//        }
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int index=0; index<10; index++)
                {
                    increment();

                    System.out.println(Thread.currentThread().getName()+" "+count);
                }
//                System.out.println(count);
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int index=0; index<10; index++)
                {
                    increment();
                    System.out.println(Thread.currentThread().getName()+" "+count);
                }
//                System.out.println(count);
            }
        });

        t1.start();

        t2.start();

        try
        {
            t1.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            t2.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

    }
}
