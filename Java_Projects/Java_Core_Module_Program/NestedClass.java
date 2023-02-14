public class NestedClass {

    //private int x=2;
    void display()
    {
        System.out.println("I am in ParentClass");
    }

    class Inner
    {
        void show()
        {
            System.out.println("I am in inner class ");
        }
    }

    public static void main(String[] args) {

        NestedClass Outer = new NestedClass();
        NestedClass.Inner obj = Outer.new Inner();
        obj.show();

        new NestedClass().display();

    }

}
