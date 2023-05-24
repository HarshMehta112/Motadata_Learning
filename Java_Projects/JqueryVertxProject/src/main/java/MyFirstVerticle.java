
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


public class MyFirstVerticle extends AbstractVerticle
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MyFirstVerticle.class.getName());

    }

    private Map< Integer, Article > readingList = new HashMap<>();

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        createSomeData();

        Router router = Router.router(vertx);

        router.route("/*").handler(StaticHandler.create());

        router.get("/api/articles").handler(this :: getAll);

        router.get("/api/articles/:id").handler(this :: getOne);

        router.route("/api/articles*").handler(BodyHandler.create());

        router.post("/api/articles").handler(this :: addOne);

        router.delete("/api/articles/:id").handler(this :: deleteOne);

        router.put("/api/articles/:id").handler(this :: updateOne);


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


    private void createSomeData ()
    {

        Article article1 = new Article("3 mistakes of my life", "https://www.google.org/");

        readingList.put(article1.getId(), article1);

        Article article2 = new Article("Reactive Programming", "https://www.google.org/");

        readingList.put(article2.getId(), article2);
    }

    private void getAll (RoutingContext routingContext)
    {

        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(readingList.values()));
    }

    private void addOne (RoutingContext routingContext)
    {

        Article article = routingContext.body().asJsonObject().mapTo(Article.class);

        readingList.put(article.getId(), article);

        routingContext.response().setStatusCode(201)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(article));
    }

    private void deleteOne (RoutingContext routingContext)
    {

        String id = routingContext.request().getParam("id");
        try
        {
            Integer idAsInteger = Integer.valueOf(id);

            readingList.remove(idAsInteger);

            routingContext.response().setStatusCode(204).end();
        }
        catch ( NumberFormatException e )
        {
            routingContext.response().setStatusCode(400).end();
        }
    }


    private void getOne (RoutingContext routingContext)
    {

        String id = routingContext.request().getParam("id");
        try
        {
            Integer idAsInteger = Integer.valueOf(id);

            Article article = readingList.get(idAsInteger);

            if ( article == null )
            {
                routingContext.response().setStatusCode(404).end();
            }
            else
            {
                routingContext.response().setStatusCode(200)
                        .putHeader("content-type", "application/json; charset=utf-8")
                        .end(Json.encodePrettily(article));
            }
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

            Article article = readingList.get(idAsInteger);

            if ( article == null )
            {
                routingContext.response().setStatusCode(404).end();
            }
            else
            {
                JsonObject body = routingContext.body().asJsonObject();

                article.setTitle(body.getString("title")).setUrl(body.getString("url"));

                readingList.put(idAsInteger, article);

                routingContext.response().setStatusCode(200)
                        .putHeader("content-type", "application/json; charset=utf-8")
                        .end(Json.encodePrettily(article));
            }
        }
        catch ( NumberFormatException e )
        {
            routingContext.response().setStatusCode(400).end();
        }


    }

}