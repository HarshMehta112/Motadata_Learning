import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IteratingOverLinkedList
{
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();

        list.add("Harsh");

        list.add("mehta");

        list.add("motdata");

        list.forEach(IteratingOverLinkedList-> System.out.println(IteratingOverLinkedList));

        System.out.println("-----------------------------------------");

        Iterator itr = list.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("-----------------------------------------");

        Iterator itr1 = list.descendingIterator();

        while(itr1.hasNext())
        {
            System.out.println(itr1.next());
        }



    }


}
