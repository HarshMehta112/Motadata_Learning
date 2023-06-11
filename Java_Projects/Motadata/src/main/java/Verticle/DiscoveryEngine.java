package Verticle;

import Utils.Constants;
import Utils.SpawnProcess;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class DiscoveryEngine extends AbstractVerticle
{
    EventBus eventBus;

    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        eventBus = vertx.eventBus();

        eventBus.consumer(Constants.RUN_DISCOVERY_SPAWN_PEROCESS,handler->
        {
            JsonObject deviceDetails = (JsonObject) handler.body();

            deviceDetails.put("category","discovery");

            JsonArray inputArray = new JsonArray().add(deviceDetails);

            try
            {
                vertx.executeBlocking(blockingHandler->
                {
                    System.out.println(Thread.currentThread().getName());

                    System.out.println(deviceDetails);

                    JsonObject discoveryResult = SpawnProcess.spwanProcessForDiscovery(inputArray);

                    System.out.println(discoveryResult.getString(deviceDetails.getString("ip")));

                    if(discoveryResult.getString(deviceDetails.getString("ip")).equals("success"))
                    {
                        handler.reply(deviceDetails.getString("id"));
                    }
                    else
                    {
                        handler.reply("");
                    }

                },false);

            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

        });

    }
}
