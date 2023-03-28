
abstract class Abcd
{
    abstract void display();
}

public class AbstractClass extends Abcd {
    void display()
    {
        System.out.println("Hello ");
    }
    public static void main(String[] args) {

        Abcd obj = new AbstractClass();
        obj.display();

    }
}
