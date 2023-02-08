interface Printable{
    default void show()
    {
        System.out.println("I am in Printable Interface");
    };
}
interface Showable {
    void show1();
    default void show()
    {
        System.out.println("I am in Showable Interface");
    };
}

public class InterfaceExample implements Showable,Printable  {

    public static void main(String[] args) {
        InterfaceExample obj = new InterfaceExample();
        obj.show();
    }

    @Override
    public void show1() {

    }

    @Override
    public void show() {
        Showable.super.show();
    }
}
