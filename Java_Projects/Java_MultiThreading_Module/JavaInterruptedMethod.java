public class JavaInterruptedMethod extends Thread
{
    @Override
    public void run()
    {
//        System.out.println(Thread.interrupted());

        System.out.println(Thread.currentThread().isInterrupted());

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
            System.out.println("Thread Interuptted");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        JavaInterruptedMethod thead = new JavaInterruptedMethod();

        thead.setName("harsh");

        thead.start();

        thead.interrupt();

    }



}
