
class Abc
{
    int id;
    String name;
    void getdetails(int i, String s)
    {
        id = i;
        name=s;
    }
    void show()
    {
        System.out.println(id);
        System.out.println(name);
    }
}


public class InheritanceDemo extends Abc {

    public static void main(String[] args) {
        InheritanceDemo obj = new InheritanceDemo();
        obj.getdetails(33,"Harsh");
        obj.show();
    }

}
