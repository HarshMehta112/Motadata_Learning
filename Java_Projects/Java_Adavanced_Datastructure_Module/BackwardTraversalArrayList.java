import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BackwardTraversalArrayList
{

    public static void main(String args[])
    {

        List<String> fruitList = new ArrayList<>();

        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("Strawberry");

        System.out.println(fruitList);

        ListIterator itr = fruitList.listIterator();

        itr.next();

        itr.next();

        itr.next();

        itr.next();

        while(itr.hasPrevious())
        {
            System.out.println("Index " + itr.previousIndex() + " list element " + itr.previous() );
        }


    }

}
