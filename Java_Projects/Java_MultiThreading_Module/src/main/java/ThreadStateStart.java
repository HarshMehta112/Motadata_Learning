public class ThreadStateStart extends Thread
{
    public void run()
    {
        System.out.println("Thread Starting");
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadStateStart obj = new ThreadStateStart();

        obj.start();

        obj.join();

        Thread threadobj = new Thread(){
            @Override
            public void run() {
                System.out.println("Runnnnnnnnnnnnnnnnnn................");
            }
        };

        threadobj.start();

//        threadobj.join();
        System.out.println(threadobj.getState());
        System.out.println(threadobj.getName());


    }

}
