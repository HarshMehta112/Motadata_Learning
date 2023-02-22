import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Arraylist {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(arr);

        arr.add(2,4);

        System.out.println(arr);

        arr.clear();

        System.out.println(arr);

        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(arr.get(2));

        System.out.println(arr.indexOf(2));

        arr.remove(1);

        System.out.println(arr);

        arr.add(2);
        arr.add(5);
        arr.add(6);

        System.out.println(arr);

        System.out.println(arr.size());

        arr.set(2,3);

        System.out.println(arr);

        arr.trimToSize();

        ArrayList<Integer> newarr = new ArrayList<>();

        newarr = (ArrayList<Integer>) arr.clone();

        System.out.println(newarr);

        Iterator<Integer> itr = arr.iterator();
        System.out.println("list: "+arr);
        while(itr.hasNext())
        {
            if (itr.next().equals(3)) {
                Integer val = itr.next();
            }

        }
        System.out.println("");
        ListIterator<Integer> itr1 = arr.listIterator();

        while(itr1.hasNext())
        {
            System.out.print(itr1.next()+" ");
        }
        arr.removeAll(arr);

        System.out.println("i am "+arr);

        System.out.println((itr.hasNext()));

    }


}
