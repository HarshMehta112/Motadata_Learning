public class MyRunnable implements Runnable
{
    private Myobject myObject = null;
    private int count = 0;

    MyRunnable(){}
    public MyRunnable(Myobject myObject)
    {
        this.myObject = myObject;

    }

    @Override
    public void run()
    {
        System.out.println(myObject);

        for(int iterator=0;iterator<=100000;iterator++)
        {
            this.count++;
        }

        System.out.println(Thread.currentThread().getName()+" "+count);

    }
}
