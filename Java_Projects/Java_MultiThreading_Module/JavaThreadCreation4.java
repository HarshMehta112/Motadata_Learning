public class JavaThreadCreation4
{
    public static void main(String[] args) {

        Runnable runnable = ()->{
            System.out.println("I am in lamda function");
        };

        Thread obj = new Thread(runnable);

        obj.start();


    }
}
