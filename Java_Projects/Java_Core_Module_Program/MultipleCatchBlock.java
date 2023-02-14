public class MultipleCatchBlock {

    public static void main(String[] args) {

        try
        {
            int array[] = new int[3];
            array[44]=4;
            int var = 4/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Main program excecuted without exception");
    }

}
