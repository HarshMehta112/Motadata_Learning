public class Varargs {

    static void varargsOverloading(boolean b,int i, int j, int k)
    {
        System.out.println("Varargs with no varargs");
    }
    static void varargsOverloading(boolean b, int...list)
    {
        System.out.println("Varargs with varars arguments");
        System.out.println(list.length);
    }

    public static void main(String[] args) {

        varargsOverloading(true,1,2,3);
        varargsOverloading(true,1,2,43,4,5,67,66);


    }

}
