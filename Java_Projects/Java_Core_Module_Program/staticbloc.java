public class staticbloc {

    static int var;
    staticbloc() {
        System.out.println("I am in constructor");
    }
    static{
        System.out.println("Hello in static block");
    }

    {
        System.out.println("Second block");
        var = 10;
        System.out.println(var);
    }

    public static void main(String[] args) {
        staticbloc obj = new staticbloc();
    }
}
