public class BasicSyntexPractice {

    public static void main(String [] args)
    {
        String s = "Harsh";
        String s1 = "Harsh";

        String s2 = new String("Harsh");
        String s3 = new String("Harsh");

        if(s2.equals(s3)) {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }


    }
}
