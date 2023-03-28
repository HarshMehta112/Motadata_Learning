import java.util.*;
public class ArrayListSorting {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("banana");

        list.add("apple");

        list.add("grapes");

        list.add("mango");

        Collections.sort(list);

        for(String temp_string:list)
        {
            System.out.println(temp_string);
        }

        list.clear();

        List<Integer> lit = new ArrayList<>();

        System.out.println(lit);

        Iterator itr1 = lit.iterator();

        System.out.println(itr1.hasNext());

        ListIterator itr = list.listIterator();

        System.out.println(itr.hasNext());

    }

}
