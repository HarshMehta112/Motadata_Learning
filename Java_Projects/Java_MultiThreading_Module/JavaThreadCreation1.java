public class JavaThreadCreation1 extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread strated running");
        Thread.currentThread().stop();
    }

    public static void main(String[] args) throws InterruptedException {

        JavaThreadCreation1 thread = new JavaThreadCreation1();

        thread.start();
        Thread.sleep(10);
        System.out.println(thread.getName()+" "+thread.getState());
//        System.out.println(thread.getName()+" "+thread.getState());


        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());

        System.out.println("hii");

    }
}
