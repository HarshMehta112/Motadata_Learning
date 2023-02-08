interface LamdaExample{
    void fun();
    default void display()
    {
        System.out.println("I am in Default method");
    }
    static void show()
    {
        System.out.println("I am in static method");
    }
}

public class LamdaExpressions{

    public static void main(String[] args) {
        LamdaExample l = ()->{
            System.out.println("I am in lamda function");
        };

        l.fun();
        l.display();
        LamdaExample.show();
    }

}
