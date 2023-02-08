class Demoss {
    static void show()
    {
        System.out.println("I am in Dmeoss");
    }
}
public class SuperKeyword extends Demoss{

    static void show()
    {
        System.out.println("I am in SuperclassKey");
    }

    public void fun() {
        super.show();
    }

    public static void main(String[] args) {

        SuperKeyword obj = new SuperKeyword();
        new SuperKeyword().fun();

    }


}
