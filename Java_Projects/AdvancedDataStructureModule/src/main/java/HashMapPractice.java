import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // create an HashMap
        HashMap<String, Integer> prices1 = new HashMap<>();

        // insert entries to the HashMap
        prices1.put("Pant", 230);
        prices1.put("Shoes", 350);
        System.out.println("HashMap 1: " + prices1);

        // create another hashmap
        HashMap<String, Integer> prices2 = new HashMap<>();

        //insert entries to the HashMap
        prices2.put("Shirt", 150);
        prices2.put("Shoes", 320);
        System.out.println("HashMap 2: " + prices2);

        prices2.forEach((key, value) -> prices1.merge(key, value, (oldValue, newValue) -> {

            // return the smaller value
            if (oldValue < newValue) {
                return oldValue;
            }
            else {
                return newValue;
            }
        }));

        System.out.println("Merged HashMap: " + prices1);
    }
}