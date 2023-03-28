import javax.crypto.spec.PSource;


public class MainHashMapClass
{

    public static void execute() throws InterruptedException
    {
        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                try
                {
                    Thread.sleep(10000);
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }
//                new HashMapClass1.method();

                HashMapClass1 map = new HashMapClass1();

                map.method();

            }
        },"test1");

        thread1.start();

        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                try
                {
                    Thread.sleep(10000);
                }
                catch ( InterruptedException e )
                {
                    e.printStackTrace();
                }
                HashMapClass2 map = new HashMapClass2();

                map.method();
            }
        },"test2");

        thread2.start();
        thread2.join();
//        System.out.println('J');

        Thread thread3 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {try
            {
                Thread.sleep(10000);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
                HashMapClass3 map = new HashMapClass3();

                map.method();
            }
        },"test3");

        thread3.start();

        Thread thread4 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {try
            {
                Thread.sleep(20000);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
                HashMapClass4 map = new HashMapClass4();

                map.method();
            }
        },"test4");

        thread4.start();

        Thread thread5 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {try
            {
                Thread.sleep(30000);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
                HashMapClass5 map = new HashMapClass5();

                map.method();
            }
        },"test5");

        thread5.start();

        Thread thread6 = new Thread(new Runnable()
        {

            @Override
            public void run ()
            {try
            {
                Thread.sleep(40000);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
                HashMapClass5 map = new HashMapClass5();

                map.method();
            }
        },"test6");

        thread6.start();

    }


    public static void main (String[] args) throws InterruptedException
    {
        execute();
    }


}
