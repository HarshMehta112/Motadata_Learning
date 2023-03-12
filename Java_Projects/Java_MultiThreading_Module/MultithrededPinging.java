import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;


class PingThread implements Runnable
{

    private String ipaddress = null;

    PingThread (String ipaddress)
    {
        this.ipaddress = ipaddress;
    }

    SingleThreadedPing obj = new SingleThreadedPing();

    @Override
    public void run ()
    {

        StringBuilder s = new StringBuilder(obj.pingUtility(ipaddress));

        System.out.println(s);
    }

}

public class MultithrededPinging
{

    public static void main (String[] args) throws IOException, InterruptedException
    {


        SingleThreadedPing pingObject = new SingleThreadedPing();

        LinkedBlockingQueue< String > IPaddressQueue = new LinkedBlockingQueue<>();

        IPaddressQueue = pingObject.setIpAddress();

//        System.out.println(queue);

        ExecutorService executor = Executors.newFixedThreadPool(16);

        for ( int index = 0; index < pingObject.noOfIPs; index++ )
        {
            Runnable PingingThread = new PingThread(IPaddressQueue.poll());

            executor.execute(PingingThread);
        }

        executor.shutdown();
//        List< Future > allFutures = new ArrayList<>();

//        for(int index = 0; index<obj.noOfIPs;index++)
//        {
//            Future<StringBuilder> future =  executor.submit(new PingThread(queue.poll()));
//
//            allFutures.add(future);
//        }
//
//        for(int index = 0; index<obj.noOfIPs;index++)
//        {
//            Future<StringBuilder> future = allFutures.get(index);
//
//            StringBuilder result = future.get();
//
//            System.out.println(result);
//        }


//        for(int i=0;i<queue.size();i++)
//        {
//            StringBuilder s = obj.pingUtility(queue.poll());
//
//            System.out.println(s);
//        }

    }

}
