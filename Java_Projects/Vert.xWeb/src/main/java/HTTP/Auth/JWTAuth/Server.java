package HTTP.Auth.JWTAuth;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.JWTAuthHandler;
import io.vertx.ext.web.handler.StaticHandler;


public class Server extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        Router router = Router.router(vertx);

        JWTAuth jwtAuth = JWTAuth.create(vertx, new JWTAuthOptions()
                .setKeyStore(new KeyStoreOptions()
                        .setType("jks")
                        .setPath("/home/harsh/JavaWork/Vert.xWeb/src/main/resources/server-keystore.jks")
                        .setPassword("harshmehta")));

        router.get("/api/newToken").handler(context ->
        {
            context.response().putHeader("Content-Type", "text/plain");

            context.response().end(jwtAuth.generateToken(new JsonObject()));
        });

        router.route("/api/*").handler(JWTAuthHandler.create(jwtAuth));

        router.get("/api/protected").handler(context ->
        {
            context.response().putHeader("Content-Type", "text/plain");

            context.response().end("a secret you should keep for yourself...");


        });
        router.route().handler(StaticHandler.create());

        vertx.createHttpServer(new HttpServerOptions().setSsl(true).setKeyStoreOptions(new JksOptions().setPath(
                "/home/harsh/JavaWork/Vert.xWeb/src/main/resources/server-keystore.jks").setPassword("harshmehta")))
                .requestHandler(router).listen(8080).onComplete(ready ->
        {
            if ( ready.succeeded() )
            {
                System.out.println("Server started lisening on port no 8080");

                startPromise.complete();
            }
            else
            {
                startPromise.fail("Some error occurred " + ready.cause().getMessage());
            }
        });


    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Server.class.getName()).onComplete(handler ->
        {
            if ( handler.succeeded() )
            {
                System.out.println("Deployed");
            }
            else
            {
                System.out.println(handler.cause().getMessage());
            }
        });
    }

}
