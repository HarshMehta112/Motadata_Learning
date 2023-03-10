public class SlippedConditions
{

    public static void main (String[] args)
    {

        ReadingThread readingThread = new ReadingThread();

        SlippedThread slippedThread = new SlippedThread();

        slippedThread.start();

        readingThread.start();
    }

}


class CommonResource
{

    static final String string = "Hello";

    static int pointerPosition = 0;

}


class SlippedThread extends Thread
{

    @Override
    public void run ()
    {

        if ( CommonResource.pointerPosition != CommonResource.string.length() )
        {
            System.out.println("Characters left! " + "I can process the string");

            try
            {
                synchronized ( this )
                {
                    wait(500);
                }
            }

            catch ( InterruptedException e )
            {
                System.out.println(e);
            }

            try
            {
                while ( CommonResource.pointerPosition < CommonResource.string.length() )
                {

                    System.out.println("Thread1 " + CommonResource.string.charAt(CommonResource.pointerPosition));

                    CommonResource.pointerPosition++;
                }
            }

            catch ( StringIndexOutOfBoundsException e )
            {
                System.out.println("\nNo more character left" + " to process. This is a" + " slipped condition");
            }
        }
    }

}


// Thread to process the whole String
class ReadingThread extends Thread
{

    @Override
    public void run ()
    {

        System.out.println("Thread2 trying to " + "process the string");

        while ( CommonResource.pointerPosition < CommonResource.string.length() )
        {

            System.out.print("Thread2 " + CommonResource.string.charAt(CommonResource.pointerPosition));

            CommonResource.pointerPosition++;
        }
    }

}


