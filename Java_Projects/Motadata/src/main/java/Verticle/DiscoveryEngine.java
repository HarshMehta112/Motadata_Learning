package Verticle;

import Utils.Constants;
import Utils.SpawnProcess;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
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

            JsonObject discoveryResult = SpawnProcess.spwanprocess(deviceDetails);

            if(discoveryResult.getString(deviceDetails.getString("ip")).equals("success"))
            {
                System.out.println("Hello"+deviceDetails.getString("id"));

                handler.reply(deviceDetails.getString("id"));
            }
            else
            {
                handler.reply("");
            }

        });

    }
}
