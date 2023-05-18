package ExecuteBlocking;

import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;



public class Sample
{
    private static final Vertx vertx = Vertx.vertx();

    private static final Logger LOGGER = LoggerFactory.getLogger(Sample.class);

    public static void main (String[] args)
    {
        vertx.executeBlocking(promise ->
        {
           try
           {
               Thread.sleep(3000);
           }
           catch ( Exception exception )
           {
               exception.printStackTrace();
           }
            System.out.println(Thread.currentThread().getName());

            LOGGER.info("I am after thread.sleep try catch block");

           promise.complete();
        });

        vertx.executeBlocking(promise ->
        {
            LOGGER.info("I am in second executeblocking code");

            System.out.println(Thread.currentThread().getName());

            promise.complete();
        });

        vertx.<String>executeBlocking(stringPromise ->
        {
            try
            {
                Thread.sleep(5000);
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException(e);
            }

            LOGGER.info("Main Promise");

            stringPromise.complete("completed!");

            System.out.println(Thread.currentThread().getName());

        },false,stringAsyncResult -> {
            if(stringAsyncResult.succeeded())
            {
                System.out.println(stringAsyncResult.result());
            }
            else
            {
                System.out.println(stringAsyncResult.cause().getMessage());
            }
        });

        vertx.executeBlocking(promise ->
        {
            try
            {
                Thread.sleep(5000);
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException(e);
            }

            LOGGER.info("I am after string executeblocking code");

            System.out.println(Thread.currentThread().getName());

            promise.complete();
        });

        vertx.executeBlocking(promise ->
        {
            try
            {
                Thread.sleep(5000);
            }
            catch ( InterruptedException e )
            {
                throw new RuntimeException(e);
            }
            LOGGER.info("I am after executeblocking code 2");

            System.out.println(Thread.currentThread().getName());

            promise.complete();
        });

    }

}
