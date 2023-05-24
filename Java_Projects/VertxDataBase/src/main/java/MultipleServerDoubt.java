import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class MultipleServerDoubt extends AbstractVerticle
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Verticle2.class.getName(),new DeploymentOptions().setInstances(4)).onComplete(ready->
        {
            if(ready.succeeded())
            {
                System.out.println("Deployed 2");
            }
            else
            {
                System.out.println("MultipleServerDoubt: Undeploy: "+ready.cause().getMessage());
            }
        });
//        vertx.deployVerticle(Verticle1.class.getName()).onComplete(ready->
//        {
//            if(ready.succeeded())
//            {
//                System.out.println("Deployed 1");
//            }
//            else
//            {
//                System.out.println("MultipleServerDoubt: Undeploy: "+ready.cause().getMessage());
//            }
//        });
    }

}
