import java.util.*;

public class LinkedHashMapImplement
{
    public static void main(String[] args)
    {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>(20,75,false);

        map.put("Harsh",2);

        map.put("Tirth",3);

        map.put("Axat",4);

        map.putIfAbsent("Mehta",7);

        map.forEach((key,value)->{
            System.out.println(key+" "+value);
        });



    }



}
