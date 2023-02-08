
interface Client
{
    default void Print()
    {
        System.out.println("Print in Client Interface");
    }
}
interface Server
{
    default void Print()
    {
        System.out.println("Print in Server Interface");
    }
}


public class InterfaceAmbiguity implements Client,Server {

    public void Print()
    {
        System.out.println("I am in main");
    }
    public static void main(String[] args) {
        Client c = new InterfaceAmbiguity();
        c.Print();
    }
}
