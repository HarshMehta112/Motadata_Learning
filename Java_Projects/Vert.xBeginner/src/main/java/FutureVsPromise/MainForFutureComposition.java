package FutureVsPromise;

import io.vertx.core.Vertx;


public class MainForFutureComposition
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(FutureComposition.class.getName()).onComplete(result->
        {
            System.out.println("I am in verticle onComplete Method");

            if(result.succeeded())
            {
                System.out.println(result.result());

//                vertx.close();
            }
            else
            {
                System.out.println(result.cause().getMessage());

//                vertx.close();
            }
        });
    }

}
