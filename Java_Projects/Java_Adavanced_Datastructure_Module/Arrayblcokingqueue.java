
import java.util.*;
import java.util.concurrent.*;
public class Arrayblcokingqueue {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(12);

        queue.add(12);

        queue.add(13);

        queue.add(14);

        ArrayList array = new ArrayList();

        queue.drainTo(array);

        System.out.println(array);

        System.out.println(queue);


        System.out.println(queue.take());

        System.out.println(queue.parallelStream());



    }
}
