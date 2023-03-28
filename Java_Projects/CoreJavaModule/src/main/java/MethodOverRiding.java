class Demos{
    void display()
    {
        System.out.println("Hello I am calling from Demos");
    }
}


public class MethodOverRiding extends Demos{

    void display()
    {
        System.out.println("I am calling from MethodOverrinding");
    }

    public static void main(String[] args) {
        //new MethodOverRiding().display();
        Demos obj = new MethodOverRiding();
        obj.display();

    }
}
