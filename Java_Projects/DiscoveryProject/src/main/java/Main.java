
import io.vertx.config.ConfigRetriever;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.HashMap;
import java.util.Map;


public class Main extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Main.class.getName()).onSuccess(ready->
        {
            System.out.println("yes");
        });

    }

    private Map< Integer, Device > deviceList = new HashMap<>();

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        Router router = Router.router(vertx);

        router.route("/login*").handler(StaticHandler.create().setIndexPage("Discovery.html"));

        router.route("/login/articles*").handler(BodyHandler.create());

        router.post("/login/articles").handler(this :: addOne);

        router.delete("/login/articles/:id").handler(this :: deleteOne);

        router.put("/login/articles/:id").handler(this :: updateOne);


        ConfigRetriever retriever = ConfigRetriever.create(vertx);
        retriever.getConfig(
                config ->
                {
                    if ( config.failed() )
                    {
                        startPromise.fail(config.cause());
                    }
                    else
                    {
                        vertx.createHttpServer().requestHandler(router)
                                .listen(config.result().getInteger("HTTP_PORT", 8080),
                                        result ->
                                        {
                                            if ( result.succeeded() )
                                            {
                                                startPromise.complete();
                                            }
                                            else
                                            {
                                                startPromise.fail(result.cause());
                                            }
                                        }
                                );
                    }
                }
        );
    }





    private void addOne (RoutingContext routingContext)
    {

        Device device = routingContext.body().asJsonObject().mapTo(Device.class);

        deviceList.put(device.getId(), device);

        routingContext.response().setStatusCode(201)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(device));
    }

    private void deleteOne (RoutingContext routingContext)
    {

        String id = routingContext.request().getParam("id");
        try
        {
            Integer idAsInteger = Integer.valueOf(id);

            deviceList.remove(idAsInteger);

            routingContext.response().setStatusCode(204).end();
        }
        catch ( NumberFormatException e )
        {
            routingContext.response().setStatusCode(400).end();
        }
    }


    private void updateOne (RoutingContext routingContext)
    {

        String id = routingContext.request().getParam("id");
        try
        {
            Integer idAsInteger = Integer.valueOf(id);

            Device device = deviceList.get(idAsInteger);

            if ( device == null )
            {
                routingContext.response().setStatusCode(404).end();
            }
            else
            {
                JsonObject body = routingContext.body().asJsonObject();

                device.setName(body.getString("name"));
                device.setIp(body.getString("ip"));
                device.setUsername(body.getString("username"));
                device.setPassword(body.getString("password"));


                deviceList.put(idAsInteger, device);

                routingContext.response().setStatusCode(200)
                        .putHeader("content-type", "application/json; charset=utf-8")
                        .end(Json.encodePrettily(device));
            }
        }
        catch ( NumberFormatException e )
        {
            routingContext.response().setStatusCode(400).end();
        }


    }

}