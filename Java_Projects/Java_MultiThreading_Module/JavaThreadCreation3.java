public class JavaThreadCreation3
{
    public static void main(String[] args) {

        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("I am in run method");
            }
        };

        Thread obj = new Thread(runnable);
        obj.start();


    }
}
