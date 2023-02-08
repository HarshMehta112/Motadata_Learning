public class DefaultExceptionGeneration {

    public void divide()
    {
        System.out.println((4/0));
    }

    public static void main(String[] args) {

        try
        {
            DefaultExceptionGeneration Div = new DefaultExceptionGeneration();
            Div.divide();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }


}
