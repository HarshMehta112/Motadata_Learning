import java.util.function.Supplier;


class ThreadLocalClass implements Runnable
{

    private ThreadLocal<String> threadLocal = new ThreadLocal<>(){

        @Override
        protected String initialValue ()
        {

            return "Motadata";
        }
    };

    // To initialize the default value

    private ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(new Supplier< String >()
    {

        @Override
        public String get ()
        {

            return "Harsh Mehta";
        }
    });

    @Override
    public void run ()
    {
        threadLocal.set("Harsh Mehta");

        threadLocal.remove();

        System.out.println(threadLocal.get());

        System.out.println(threadLocal1.get());

    }

}

public class ThreadLocalInJava
{

    public static void main (String[] args)
    {
        ThreadLocalClass runnable = new ThreadLocalClass();

        Thread thread = new Thread(runnable,"ThreadLocal");

        thread.start();
    }

}
