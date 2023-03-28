public class TryCatchTypes {

    public static void main(String[] args) {

        try {
            int a = 100;
            int b = 0;
            System.out.println((a / b));
        }
        //System.out.println("Hello");
        catch (Exception e) {
            System.out.println("Exception");
        }
    }

}
