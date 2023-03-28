import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCollections
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        List name = new ArrayList();

        name.add("anshu");

        name.add("nikunj");

        name.add("yash");

        list.addAll(name);

        list.add("harsh");

        list.add("sankalp");

        list.addFirst("harsh");

        System.out.println(list.poll());



        System.out.println(list);


    }
}
