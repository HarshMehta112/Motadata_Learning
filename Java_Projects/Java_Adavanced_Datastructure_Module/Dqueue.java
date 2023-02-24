import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Dqueue
{
    public static void main(String[] args) {

        List list = new ArrayList();

        list.add(1);

        list.add(2);

        list.add(3);

        list.add(4);

        ArrayDeque aqueue = new ArrayDeque(list);

        System.out.println(aqueue);

        System.out.println(aqueue.poll());

        System.out.println(aqueue);


    }
}
