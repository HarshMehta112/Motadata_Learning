import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class HashSetImplement
{
    public static void main(String[] args)
    {
        HashSet dayset = new HashSet();

        ArrayBlockingQueue queue = new ArrayBlockingQueue(12);

        queue.add(12);

        queue.add(13);

        queue.add(14);

        dayset.add("Monday2");

        dayset.add("Tuesday");

        dayset.add("Wednesday");

        dayset.add("Thursday");

        dayset.add("Friday");

        dayset.add("Saturday");

        dayset.add("Sunday");

        dayset.add(new StringBuffer("Monday1"));

//        dayset.add(null);

        System.out.println(dayset+" ");

        Iterator itr = dayset.iterator();

//        while(itr.hasNext())
//        {
//            Object o = itr.next();
//
//            System.out.println(o+" "+o.hashCode());
//        }

        dayset.removeIf(s->s.equals("Monday2"));

        System.out.println(dayset);

    }
}
