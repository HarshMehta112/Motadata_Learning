import java.util.ArrayList;
import java.util.List;

public class RetainAllMethodArrayList {


    public static void main(String[] args) {

        List<String> fruitList = new ArrayList<>();

        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("AApple");

        fruitList.add("Strawberry");

        List<String> fruitList1 = new ArrayList<>();

        fruitList1.add("Mango");

        fruitList1.add("Strawberry");

        fruitList.retainAll(fruitList1);

        System.out.println(fruitList);

    }


}
