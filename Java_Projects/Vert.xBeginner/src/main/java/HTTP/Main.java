package HTTP;

import io.vertx.core.Vertx;


public class Main
{
    private static Vertx vertx = Vertx.vertx();

    public static void main (String[] args)
    {
        vertx.deployVerticle(Client.class.getName()).onComplete(event->
        {
            if(event.succeeded())
            {
                System.out.println("Client Verticle Deployed");
            }
            else
            {
                System.out.println("Error in deploying Client the vertcile");

                System.out.println(event.cause().getMessage());
            }
        });

        vertx.deployVerticle(Server.class.getName()).onComplete(event->
        {
            if(event.succeeded())
            {
                System.out.println("Server Verticle Deployed");
            }
            else
            {
                System.out.println("Error in deploying the Server verticle");

                System.out.println(event.cause().getMessage());
            }
        });
    }

}
