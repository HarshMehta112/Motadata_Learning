public class StaticMethodThreadSafety
{
    public static void concat (StringBuilder result, StringBuilder sb, StringBuilder sb1)
    {
        result.append(sb);

        result.append(sb1);

        System.out.println(result);
    }

    public static void main (String[] args)
    {

        StringBuilder s1 = new StringBuilder("Harsh");

        StringBuilder s2 = new StringBuilder("Mehta");

        StringBuilder r = new StringBuilder();

        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                concat(r,s1,s2);
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                concat(r,s2,s1);
            }
        });

        thread.start();

        thread2.start();
    }

}
