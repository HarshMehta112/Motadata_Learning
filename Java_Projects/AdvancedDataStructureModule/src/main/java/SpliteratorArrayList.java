import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorArrayList {

    public static void main(String[] args) {

        List<String> fruitList = new ArrayList<>();

        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("AApple");

        fruitList.add("Strawberry");

        Spliterator<String> sptr = fruitList.spliterator();

        sptr.forEachRemaining((t)-> System.out.println(t));


    }



}
