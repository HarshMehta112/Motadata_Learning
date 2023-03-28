import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTask {

    public static void main(String[] args)
    {

        ArrayList fruitList = new ArrayList();


        List<String> fruitlist1 = new ArrayList<>();

        fruitlist1.add("harsh");

        ArrayList<ArrayList<String>> twodlist = new ArrayList<ArrayList<String>>();

        twodlist.add((ArrayList<String>) fruitlist1);

        fruitList.add(1,"hdbdh");

//        twodlist.add((ArrayList<String>) fruitlist);


        twodlist.get(0).clear();
        System.out.println(twodlist);




//        fruitList.add(10);
        fruitList.add("Mango");

        fruitList.add("Banana");

        fruitList.add("Apple");

        fruitList.add("AApple");

        fruitList.add("Strawberry");


        //fruitList.clear();

        System.out.println(fruitList);


    }


}
