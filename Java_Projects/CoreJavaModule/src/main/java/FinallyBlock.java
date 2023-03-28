public class FinallyBlock {

    public static void main(String[] args) {

        try
        {
            int var = 10/0;
            int array[] = new int[12];
        }
        catch (ArithmeticException e)
        {
            System.out.println(e);
        }

        finally {
            System.out.println("I am in finally block");
        }

    }


}
