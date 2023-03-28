public class ThreadRunMethod extends Thread
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
    }

    public static void main(String[] args)
    {
        ThreadRunMethod thread = new ThreadRunMethod();

        thread.run();

        ThreadRunMethod thread2 = new ThreadRunMethod();

        thread2.run();  //it becomes object and calls the run method

    }

}
