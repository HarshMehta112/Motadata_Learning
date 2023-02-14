public class StaticNestedClass {

    static int data = 4;
    void show()
    {
        System.out.println("I am in Outer class");
    }

    static class Inner
    {
        void display()
        {
            System.out.println("I am in Static Inner class "+data);
        }
    }

    public static void main(String[] args) {
        StaticNestedClass.Inner obj = new StaticNestedClass.Inner();
        obj.display();
    }

}
