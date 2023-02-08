public class ExceptionHandlingFinallyBlock {

    public static void main(String[] args) {

        try
        {
            int a = 100;
            int b = 0;
            System.out.println((a/b));
        }
        catch (Exception e)
        {
            System.out.println("Exception");
        }
        finally {
            System.out.println("I am in final block");
        }

    }

}
