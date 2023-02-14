public class Enums {

    public enum Season {SPRING,WINTER,FALL,SUMMER}

    public static void main(String[] args) {

        for(Season s:Season.values())
        {
            System.out.println(s);
            System.out.println(s);

        }
        System.out.println(Season.valueOf("WINTER").ordinal());


    }

}
