public class SeperateObjects
{
    public static void main(String[] args)
    {

        Myobject myobject = new Myobject();

        Runnable runnable1 = new MyRunnable(myobject);

        Runnable runnable2 = new MyRunnable(myobject);

        Thread thread1 = new Thread(runnable1,"harsh");

        Thread thread2 = new Thread(runnable2,"mehta");

        thread1.start();

        thread2.start();

    }



}
