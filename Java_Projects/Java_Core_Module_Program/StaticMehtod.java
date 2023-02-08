public class StaticMehtod {

    static  int x=0;
    protected static int cube(int a)
    {
        return a*a*a;
    }

    public static void main(String[] args) {
        int c = StaticMehtod.cube(4);
        System.out.println(c);
    }

}
