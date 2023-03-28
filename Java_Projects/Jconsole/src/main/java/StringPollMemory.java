public class StringPollMemory
{

    public static void main (String[] args)
    {
        String one = "Hello";

        String two = "Hello";

        System.out.println(one.equals(two));

        System.out.println(one==two);

        Integer i = 76;

        String three = i.toString().intern();

        String four = "76";

        System.out.println(three.equals(four));

        System.out.println(three == four);
    }

}
