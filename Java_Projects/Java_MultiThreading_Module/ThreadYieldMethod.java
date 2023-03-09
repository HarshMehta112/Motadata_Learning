public class ThreadYieldMethod extends Thread
{
    @Override
    public void run()
    {
        Thread.yield();

        for(int index=0; index<=5;index++)
        {
            System.out.println(Thread.currentThread().getName()+" "+index);
        }

    }

    public static void main(String[] args)
    {
        ThreadYieldMethod thread = new ThreadYieldMethod();

        thread.start();

//        Thread.yield();

        for(int index=0; index<=5;index++)
        {
            System.out.println(Thread.currentThread().getName()+" "+index);
        }

    }


}
