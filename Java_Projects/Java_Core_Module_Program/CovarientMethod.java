class Sample
{
    int fun()
    {
        System.out.println("I am in Sample");
        return 1;
    }
}


public class CovarientMethod {

    void fun()
    {
        System.out.println("I am in Covarient class");

    }

    public static void main(String[] args) {
        CovarientMethod obj = new CovarientMethod();
        obj.fun();
    }


}
