import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods {


    public static void main(String[] args) {

        List<String> fruitList = new ArrayList<>();

        List<String> fruitlist1 = new ArrayList<>();

        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("AApple");

        fruitList.add("Strawberry");

        //System.out.println(fruitList.removeIf(item -> item.startsWith("A")));

        System.out.println(fruitList);

        fruitList.replaceAll(item->item.startsWith("A")?"Ha":"");

    }


}
