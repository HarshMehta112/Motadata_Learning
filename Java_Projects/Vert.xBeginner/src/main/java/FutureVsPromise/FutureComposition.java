package FutureVsPromise;

import io.vertx.core.*;


public class FutureComposition extends AbstractVerticle
{
    public Future<Void> exxecuteAfterTwoSeconds()
    {

        Promise<Void> promise = Promise.promise();

        vertx.setTimer(2000,handler->
        {
            System.out.println("executeAfterTwoSecond called!");

//            promise.complete();

            promise.fail("Failed by me");
        });

        return promise.future();
    }
    public Future<Void> executeAfterFourSecond()
    {

        Promise<Void> promise = Promise.promise();

        vertx.setTimer(4000, handler ->
        {
            System.out.println("executeAfterFourSecond called!");

            promise.complete();
        });

        return promise.future();
    }

    public Future<Void> executeAfterSixSecond()
    {

        Promise<Void> promise = Promise.promise();

        vertx.setTimer(6000, handler ->
        {
            System.out.println("executeAfterSixSecond called!");

            promise.complete();
        });

        return promise.future();
    }

    public void start(Promise<Void> startPromise)
    {
        /*exxecuteAfterTwoSeconds().compose(result->executeAfterFourSecond().compose(res->executeAfterSixSecond())).onComplete(event->
        {
            if(event.succeeded())
            {
                System.out.println("All Tasks Completed-");

                startPromise.complete();

            }
            else
            {
                System.out.println("Some error caused"+event.cause().getMessage());

                startPromise.fail("Some error occured"+event.cause().getMessage());
            }
        });*/

        CompositeFuture.all(exxecuteAfterTwoSeconds(),executeAfterFourSecond(),executeAfterSixSecond()).onComplete(event->
        {
            if(event.succeeded())
            {
                System.out.println("All tasks are excuted successfully");

                startPromise.complete();
            }
            else
            {
                System.out.println("Some task are failed "+event.cause().getMessage());

                startPromise.fail("Some task are failed "+event.cause().getMessage());
            }

        });

    }



}
