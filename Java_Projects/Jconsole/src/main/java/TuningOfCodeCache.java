
public class TuningOfCodeCache
{

    static int x = 0;

    static void roll ()
    {

        try
        {
            Thread.sleep(10000);
        }
        catch ( InterruptedException e )
        {
            throw new RuntimeException(e);
        }
        for ( int i = 0; i < 1000000000; i++ )
        {
            x++;
        }
    }

    public static void main (String[] args)
    {

        try
        {
            Thread.sleep(20000);
        }
        catch ( InterruptedException e )
        {
            throw new RuntimeException(e);
        }
        new Thread(() -> roll()).start();

        new Thread(() -> roll()).start();

        new Thread(() -> roll()).start();

        new Thread(() -> roll()).start();

        new Thread(() -> roll()).start();
        try
        {
            Thread.sleep(20000);
            System.out.println(x);
        }
        catch ( InterruptedException e )
        {
            throw new RuntimeException(e);
        }
    }

}
