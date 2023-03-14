public class ProducerConsumerWaitNotify
{
    int num;

    boolean valueSet = false;
    public synchronized void put(int num)
    {
        while(valueSet)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Put : "+num);

        this.num = num;

        valueSet = true;

        notify();
    }

    public synchronized void get()
    {
        while(!valueSet)
        {
            try
            {
                wait();

            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Get : "+num);

        valueSet = false;

        notify();
    }
}

class Producer implements Runnable
{
    ProducerConsumerWaitNotify object;

    public Producer(ProducerConsumerWaitNotify object)
    {
        this.object = object;

        Thread thread = new Thread(this,"Producer");

        thread.start();
    }

    @Override
    public void run()
    {
        int index = 0;

        while(true)
        {
            object.put(index++);

            try
            {
                Thread.sleep(1000);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable
{
    ProducerConsumerWaitNotify object;

    public Consumer(ProducerConsumerWaitNotify object)
    {
        this.object = object;

        Thread thread = new Thread(this,"Consumer");

        thread.start();
    }

    @Override
    public void run()
    {
        while(true)
        {
            object.get();

            try
            {
                Thread.sleep(3000);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}

class InterThread
{
    public static void main(String[] args)
    {

        ProducerConsumerWaitNotify obj = new ProducerConsumerWaitNotify();

        new Producer(obj);

        new Consumer(obj);

    }
}

