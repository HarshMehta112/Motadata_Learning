import java.util.HashMap;
import java.util.Map;

public class HashMapMethod
{
    public static void main(String[] args)
    {
        HashMap<String,Integer> map = new HashMap<>();

        HashMap<String,Integer> map1 = new HashMap<>();

        map.clear();

        System.out.println(map.isEmpty());

        map.put("Harsh",2);

        map.put("Tirth",3);

        map.put("Axat",4);

        map.putIfAbsent("Mehta",7);

        map.putIfAbsent("Harsh",3);

        System.out.println(map.size());

        System.out.println(map.containsKey("Mehta"));

        System.out.println(map.containsValue(3));

        System.out.println(map.get("Mehta"));

        map.remove("Mehta");

        map.remove("Axat",21);

        map.compute("Mehta",(key,value)->(value==null ? 1 :value+1));

        map.computeIfAbsent("mehta",key->44);

        map1.put("mehta",2);

        map1.put("harsh",3);

        map.putAll(map1);

//        for(Map.Entry mp: map.entrySet())
//        {
//            System.out.println(mp.getKey()+ " "+mp.getValue());
//        }

        map.forEach((key,value)->
        {
            System.out.println(key+" "+value);
        });

//        map1.forEach((key,value)->{
//            System.out.println(key+" "+value);
//        });



    }
}
