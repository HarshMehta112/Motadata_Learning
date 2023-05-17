package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.*;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.auth.properties.PropertyFileAuthentication;


public class BasicAuth extends AbstractVerticle
{

    static
    {
        System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory");
    }

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());

        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));

        PropertyFileAuthentication authentication = PropertyFileAuthentication.create(vertx, "/home/harsh/JavaWork" +
                "/Vert.xWeb/src/main/resources/webroot/user.properties");

        router.route().handler(StaticHandler.create().setCachingEnabled(false));

        router.route("/private/*").handler(RedirectAuthHandler.create(authentication,"/Login.html"));

        router.route("/loginHandler").handler(FormLoginHandler.create(authentication));

        router.route("/private/*").handler(StaticHandler.create().setCachingEnabled(false));

        router.route("/logout").handler(context -> {

            context.clearUser();

            context.response().putHeader("location", "/").setStatusCode(302).end();
        });

        vertx.createHttpServer().requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("server started liestning on port no 8080");

               startPromise.complete();
           }
           else
           {
               startPromise.fail("some error occurred "+ready.cause().getMessage());
           }
        });


    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(BasicAuth.class.getName());
    }

}
