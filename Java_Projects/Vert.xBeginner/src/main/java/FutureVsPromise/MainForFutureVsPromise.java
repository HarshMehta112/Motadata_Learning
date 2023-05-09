package FutureVsPromise;

import io.vertx.core.Vertx;


public class MainForFutureVsPromise
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(DemoVerticle.class.getName()).onComplete(result->
        {
            System.out.println("I am in onComplete method");

            if(result.succeeded())
            {
                System.out.println("Result succeed "+result.result());
                vertx.close();
            }
            else
            {
                System.out.println(result.cause().getCause());
                vertx.close();
            }

        });
    }

}
