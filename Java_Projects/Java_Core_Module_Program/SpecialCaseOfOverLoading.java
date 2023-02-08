public class SpecialCaseOfOverLoading {

    void show(int a)
    {
        System.out.println("Int method overloading" + a);
    }
    void show(String s)
    {
        System.out.println("string method overloading");
    }

    public static void main(String[] args) {
        SpecialCaseOfOverLoading obj = new SpecialCaseOfOverLoading();
        obj.show('a');
    }

}
