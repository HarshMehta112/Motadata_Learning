import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;


public class Vertcile extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Vertcile.class.getName());

        vertx.deployVerticle(DataBase.class.getName());
    }


    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        Router router = Router.router(vertx);

        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));

        router.route("/*").handler(StaticHandler.create("webroot").setIndexPage("login.html"));

        router.route().handler(BodyHandler.create());

        router.post("/login").handler(context->
        {
            EventBus eventBus = vertx.eventBus();

            eventBus.request("checkUser",context.body().asJsonObject(),response->
            {
                if(response.succeeded())
                {
                    if(response.result().body().toString().equals("Valid User"))
                    {
                        context.response().setStatusCode(200).end(new JsonObject().put("key","Valid user").encode());

                        System.out.println("valid user");
                    }
                    else
                    {
                        context.response().setStatusCode(404).end("Invalid User");

                        System.out.println("invalid user ");
                    }
                }
                else
                {
                    startPromise.fail("Some Error "+response.cause().getMessage());
                }
            });
        });


        HttpServer server = vertx.createHttpServer();

        server.requestHandler(router).listen(8080).onComplete(ready->
        {
            if(ready.succeeded())
            {
                System.out.println("Server started listening on 8080");

                startPromise.complete();
            }
            else
            {
                startPromise.fail("Some Error "+ready.cause().getMessage());
            }
        });

    }

}
