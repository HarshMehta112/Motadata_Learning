public class JavaThreadCreation2 extends Thread
{

    @Override
    public void run() {
        System.out.println("I am in run method");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        JavaThreadCreation2 javaThreadCreation2 = new JavaThreadCreation2();
        Thread javathread = new Thread(javaThreadCreation2);

        javathread.start();
        javaThreadCreation2.start();

    }


}
