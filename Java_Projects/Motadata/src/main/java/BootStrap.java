import Verticle.DatabaseVerticle;
import Verticle.DiscoveryEngine;
import Verticle.PublicAPIVerticle;
import io.vertx.core.Vertx;

public class BootStrap
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new DatabaseVerticle()).onComplete(deplyment->
        {
            if(deplyment.succeeded())
            {
                System.out.println("Public API deployed Successfully");
            }
            else
            {
                System.out.println("Some error occurred "+deplyment.cause().getMessage());

            }
        });

        vertx.deployVerticle(PublicAPIVerticle.class.getName()).onComplete(deplyment->
        {
            if(deplyment.succeeded())
            {
                System.out.println("Public API deployed Successfully");
            }
            else
            {
                System.out.println("Some error occurred "+deplyment.cause().getMessage());
            }
        });

        vertx.deployVerticle(DiscoveryEngine.class.getName()).onComplete(deplyment->
        {
            if(deplyment.succeeded())
            {
                System.out.println("Public API deployed Successfully");
            }
            else
            {
                System.out.println("Some error occurred "+deplyment.cause().getMessage());
            }
        });


    }
}
