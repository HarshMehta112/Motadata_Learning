public class TotalErningsJavaNotify extends Thread
{
    int total = 0;

    @Override
    public void run()
    {
        for(int index = 0; index<=4; index++)
        {
            total += 100;
        }
    }
}

class MovieBookAppp
{
    public static void main(String[] args)
    {
        TotalErningsJavaNotify thread = new TotalErningsJavaNotify();

        thread.start();

//        System.out.println("Total ernings "+ thread.total);

    }
}
