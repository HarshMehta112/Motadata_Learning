import java.util.TreeMap;

//class TreeMapMethods {
//    public static void main(String[] args) {
//        TreeMap<String, Integer> numbers = new TreeMap<>();

//        numbers.put("First", 1);

//        numbers.put("Second", 2);

//        numbers.put("Third", 3);

//        System.out.println("TreeMap: " + numbers);
//
//        // Using the firstKey() method
//        String firstKey = numbers.firstKey();

//        System.out.println("First Key: " + firstKey);
//
//        // Using the lastKey() method
//        String lastKey = numbers.lastKey();

//        System.out.println("Last Key: " + lastKey);
//
//        // Using firstEntry() method
//        System.out.println("First Entry: " + numbers.firstEntry());
//
//
//        // Using the lastEntry() method
//        System.out.println("Last Entry: " + numbers.lastEntry());
//    }
//}

import java.util.TreeMap;

//class TreeMapMethods {
//    public static void main(String[] args)
//    {
//
//        TreeMap<String, Integer> numbers = new TreeMap<>();
//
//        numbers.put("First", 1);
//
//        numbers.put("Second", 5);
//
//        numbers.put("Third", 4);
//
//        numbers.put("Fourth", 6);
//
//        System.out.println("TreeMap: " + numbers);
//
//        System.out.println("Using higherKey(): " + numbers.higherKey("Fourth"));
//
//        System.out.println("Using higherEntry(): " + numbers.higherEntry("Fourth"));
//
//        System.out.println("\nUsing lowerKey(): " + numbers.lowerKey("Fourth"));
//
//        System.out.println("Using lowerEntry(): " + numbers.lowerEntry("Fourth"));
//
//        System.out.println("\nUsing ceilingKey(): " + numbers.ceilingKey("Fourth"));
//
//        System.out.println("Using ceilingEntry(): " + numbers.ceilingEntry("Fourth"));
//
//        System.out.println("\nUsing floorKey(): " + numbers.floorKey("Fourth"));
//
//        System.out.println("Using floorEntry(): " + numbers.floorEntry("Fourth"));
//
//
//    }
//}

class TreeMapMethods
{
    public static void main(String[] args)
    {
        TreeMap<String,Integer> map = new TreeMap();

        map.put("Harsh",2);

        map.put("Nikunj",4);

        map.put("Sankalp",7);

        System.out.println(map.headMap("Sankalp",true));

    }
}