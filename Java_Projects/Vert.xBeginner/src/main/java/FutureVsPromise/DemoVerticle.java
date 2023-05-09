package FutureVsPromise;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;


public class DemoVerticle extends AbstractVerticle
{
    @Override
    public void start(Promise<Void> startPromise)
    {
        count(10).onComplete(result->
        {
            System.out.println("in count method : " + Thread.currentThread().getName());


            System.out.println("I am in onComplete of inside Verticle");

            if(result.succeeded())
            {
                System.out.println(result.result());

                startPromise.complete();
            }
            else
            {
                System.out.println("Some error occured "+result.cause().getMessage());

                startPromise.fail("Some error occured "+result.cause().getMessage());
            }

        });
    }


    private Future<Integer> count(int n)
    {
        Promise<Integer> integerPromise = Promise.promise();

        System.out.println("in count method : " + Thread.currentThread().getName());

        int sum=0;

        try
        {
            for(int i=0;i<n;i++)
            {
                sum+=i;
//                if (i == 9)
//                {
//                    throw new RuntimeException("9 not found!");
//                }
            }
            integerPromise.complete(sum);
        }
        catch ( Exception exception )
        {
            integerPromise.fail(exception.getCause().getMessage());
        }
        return integerPromise.future();
    }

}


