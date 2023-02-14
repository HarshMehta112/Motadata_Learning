
class AB
{
    void show()
    {
        System.out.println("I am in A method");
    }
}
class BB extends AB
{
    void display()
    {
        System.out.println("I am in B method");
    }
}

public class ObjectDownCastUpCast {

    public static void main(String[] args) {
        AB obj = new BB();
        obj.show();
        BB obj1 = (BB)obj;
        obj1.display();
    }


}