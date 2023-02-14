public class NestedTryCatchBlock {

    public static void main(String[] args) {

        try
        {
            try
            {
                int var = 5/0;
            }
            catch (ArithmeticException e)
            {
                System.out.println(e);
            }
            try
            {
                int array[] = new int[5];
                array[7]=3;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

}
