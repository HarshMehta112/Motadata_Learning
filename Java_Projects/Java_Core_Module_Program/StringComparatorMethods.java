public class StringComparatorMethods {

    public static void main(String[] args) {
        String s1 = "Harsh";
        String s2 = "harsh";

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "a";
        String s4 = "A";

        System.out.println(s3.compareTo(s4));

    }



}
