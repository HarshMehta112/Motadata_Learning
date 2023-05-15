package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;


public class SubRouter2 extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        JsonObject jsonObject = new JsonObject();

        jsonObject.put("1","ahmedabad");

        jsonObject.put("2","Surat");

        jsonObject.put("3","Surendranagar");

        Router mainRouter = Router.router(vertx);

        Router addRouter = Router.router(vertx);

        Router listRouter = Router.router(vertx);

        mainRouter.route("/cities/*").subRouter(addRouter);

        mainRouter.route("/cities/*").subRouter(listRouter);

        addRouter.post("/:id/:Name").handler(context->
        {
            context.json(jsonObject.put(context.pathParam("id"), (context.pathParam("Name"))));
        });

        listRouter.get("/info").handler(context->
        {
           context.json(jsonObject);
        });

        server.requestHandler(mainRouter).listen(8080).onComplete(ready->
        {
            if(ready.succeeded())
            {
                System.out.println("server started listening port no 8080");

                startPromise.complete();
            }
            else
            {
                System.out.println("Some error occurred "+ready.cause().getMessage());

                startPromise.fail("Some error occurred "+ready.cause().getMessage());
            }
        });

    }

    public static void main (String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(SubRouter2.class.getName()).onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println("verticle deployd successfully");
            }
            else
            {
                System.out.println("Some error occuured "+handler.cause().getMessage());
            }
        });
    }

}
