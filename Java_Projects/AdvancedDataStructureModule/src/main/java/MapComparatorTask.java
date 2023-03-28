import java.util.*;

class MapComaparator implements Comparator<Map<String,String>>
{
    public int compare(Map<String,String> firstMap, Map<String,String> secondMap)
    {
        int ans  = firstMap.get("ID").compareTo((secondMap.get("ID")));

        if(ans==0)
        {
            return firstMap.get("Name").compareTo((secondMap.get("Name")));
        }
//        System.out.println(ans);
        return ans;

    }
}

public class MapComparatorTask
{
    public static void main(String[] args)
    {
        HashMap<String,String> firstMap = new HashMap<>();

        HashMap<String,String> secondMap = new HashMap<>();

        firstMap.put("ID","1");

        firstMap.put("Name", "abc");

        secondMap.put("ID","1");

        secondMap.put("Name", "xyz");

        List<HashMap<String,String>> list = new ArrayList<>();

        list.add(secondMap);

        list.add(firstMap);

        Collections.sort(list,new MapComaparator());

        System.out.println(list);

    }
}
