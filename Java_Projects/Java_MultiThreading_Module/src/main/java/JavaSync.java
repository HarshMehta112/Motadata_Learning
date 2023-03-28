public class JavaSync
{

    public static void main (String[] args)
    {
        Integer i = 10;

        try
        {
            synchronized ( i )
            {
                i.wait();
            }
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }

    }

}
