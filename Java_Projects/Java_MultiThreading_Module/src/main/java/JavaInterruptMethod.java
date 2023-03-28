public class JavaInterruptMethod extends Thread
{
    @Override
    public void run()
    {

            try
            {
                for(int index=1;index<=5;index++)
                {
                    System.out.println(Thread.currentThread().getName() + " " + index);

                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
    }

    public static void main(String[] args)
    {
        JavaInterruptMethod thread = new JavaInterruptMethod();

        thread.start();

        thread.interrupt();

    }


}
