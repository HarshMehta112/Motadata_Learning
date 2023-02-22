import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachRemainingMethodArrayList {

    public static void main(String[] args) {

        List<String> fruitList = new ArrayList<>();

        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("AApple");

        fruitList.add("Strawberry");

        Iterator itr = fruitList.iterator();

        itr.forEachRemaining((n)-> System.out.println(n));



    }


}
