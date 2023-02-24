public class ConcurrentLinkedQueue
{
    public static void main(String[] args) {

        java.util.concurrent.ConcurrentLinkedQueue concQueue = new java.util.concurrent.ConcurrentLinkedQueue();

        concQueue.add(12);

        concQueue.add(1);

        concQueue.add(11);

        concQueue.add(15);

        concQueue.add(17);

        System.out.println(concQueue);

        concQueue.poll();

        System.out.println(concQueue);

        concQueue.offer(12);

        System.out.println(concQueue);

        concQueue.remove(12);

        System.out.println(concQueue);


    }
}
