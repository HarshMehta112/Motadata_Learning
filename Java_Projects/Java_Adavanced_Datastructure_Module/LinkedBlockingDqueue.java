import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDqueue
{
    public static void main(String[] args) {

        LinkedBlockingDeque linkedBlockingDque = new LinkedBlockingDeque();

        linkedBlockingDque.add("harsh");

        linkedBlockingDque.add("harshkumar");

        linkedBlockingDque.add("sankalp");

        linkedBlockingDque.addFirst("hemant");

        System.out.println(linkedBlockingDque);

        System.out.println(linkedBlockingDque.getLast());




    }
}
