package HTTP.PipingResponse;

import io.vertx.core.Vertx;


public class Main
{

    private static Vertx vertx = Vertx.vertx();

    public static void main (String[] args)
    {
        vertx.deployVerticle(Server.class.getName()).onComplete(stringAsyncResult ->
        {
           if(stringAsyncResult.succeeded())
           {
               System.out.println("deploy successfully");
           }
           else
           {
               System.out.println("not deploy successfully");
           }
        });
    }

}
