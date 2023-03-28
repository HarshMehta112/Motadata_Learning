import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class ExploringStrings
{

    public static void main (String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                Date start = new Date();

                List<String> strings = new ArrayList<>();

                for(Integer index=0;index<=100000000;index++)
                {
                    String ss = new String("HM");

                    System.out.println(ss);

                    String s = index.toString().intern();

                    strings.add(s);
                }

                Date end = new Date();
                System.out.println(end.getTime()-start.getTime());
            }
        },"Harsh");
        thread.start();
    }

}
