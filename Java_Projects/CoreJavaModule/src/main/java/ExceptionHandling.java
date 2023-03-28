public class ExceptionHandling {

    public static void main(String[] args) {
        try
        {
            int data = 50/0;
        }
        catch(Throwable e)
        {
            System.out.println("Exception!!!");
            throw e;
        }
        finally
        {
            System.out.println("In the final block");
        }
        System.out.println("in the main block");
    }

}
