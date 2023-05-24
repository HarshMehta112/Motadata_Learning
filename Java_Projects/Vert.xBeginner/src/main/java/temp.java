import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;


public class temp extends AbstractVerticle
{
    public static Vertx vertx = Vertx.vertx();

    public static void main (String[] args)
    {
        var promise = Promise.promise();

        vertx.eventBus().consumer("test",handler->
        {
//            System.out.println("I am in consumer "+handler.body());

            handler.reply(handler.body());

            System.out.println("hi");
        });

//        vertx.eventBus().consumer("test",handler->
//        {
//            System.out.println("hi2");
//        });

        try
        {
            vertx.eventBus().< JsonObject >request("test",new JsonObject(),handler->
            {
                var item = handler.result().body();

                System.out.println(item);

                if(handler.succeeded())
                {
                    if(item.getString("status").equalsIgnoreCase("success"))
                    {
                        promise.complete(item);
                    }
                    else
                    {
                        promise.fail("");
                    }
                }
                else
                {
                    promise.fail("");
                }
            });
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        promise.future().onComplete(handler->
        {
           if(handler.succeeded())
           {
               System.out.println("success");
           }
           else
           {
               System.out.println("failed");
           }
        });
        vertx.close();
    }

}
