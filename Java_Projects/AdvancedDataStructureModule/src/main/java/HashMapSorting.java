import java.util.*;

public class HashMapSorting
{
    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>();

        map.put("Harsh",2);

        map.put("Tirth",3);

        map.put("Axat",4);

        List<Map.Entry<String,Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String,Integer> obj1,Map.Entry<String,Integer> obj2)
            {
                System.out.println(obj1.getValue().compareTo(obj2.getValue()));

                return (obj1.getValue().compareTo(obj2.getValue()));
            }
        });

        System.out.println(list);

        HashMap<String,Integer> mapp = new HashMap<>();

        for(Map.Entry<String,Integer> mp: map.entrySet())
        {
            System.out.println(mp.getKey()+" "+mp.getValue());
        }

    }
}
