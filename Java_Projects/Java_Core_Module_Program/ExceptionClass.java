public class ExceptionClass {

    public static void main(String[] args) {

        try
        {
            int a = 100;
            int b = 0;
            System.out.println((a/b));
        }
        catch (ArithmeticException e)
        {
            //System.out.println(e);
            e.printStackTrace();
        }

    }

}
