public class PassByReference {

    int a = 10;
    void call(PassByReference eg) {
        eg.a = eg.a+10;
    }

    public static void main(String[] args) {

        PassByReference eg = new PassByReference();
        System.out.println("Before call-by-reference: " + eg.a);

        eg.call(eg);
        System.out.println("After call-by-reference: " + eg.a);


    }
}
