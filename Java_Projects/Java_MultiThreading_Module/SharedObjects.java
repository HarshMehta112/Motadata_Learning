public class SharedObjects
{

    public static void main (String[] args)
    {

        Myobject myobject = new Myobject();

        Runnable runnable = new MyRunnable(myobject);

        Thread thread1 = new Thread(runnable, "harsh");

        Thread thread2 = new Thread(runnable, "mehta");

        thread1.start();

        thread2.start();

    }

}

