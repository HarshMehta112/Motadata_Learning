public class MethodOverloading {

    int area(int l, int b)
    {
        System.out.println(l*b);
        return l*b;
    }

    int area(int r)
    {
        System.out.println(r*r);
        return (r*r);
    }

    public static void main(String[] args) {

        MethodOverloading obj = new MethodOverloading();
        obj.area(4,5);
        obj.area(5);

    }


}
