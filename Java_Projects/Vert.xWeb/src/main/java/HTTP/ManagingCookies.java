package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;


public class ManagingCookies extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/cookie/get").handler(context->
        {
           context.response().addCookie(Cookie.cookie("name","Harsh"));

           context.response().setChunked(true);

           context.response().end("Got it!");
        });

        router.post("/cookie/add").handler(context->
        {
           Cookie cookie = context.request().getCookie("name");

            System.out.println("Cookie Name :-"+cookie.getName());

            System.out.println("Cookie Domain :-"+cookie.getDomain());

            System.out.println("Cookie getvalue :-"+cookie.getValue());

            System.out.println("Cookie getPath :-"+cookie.getPath());

            System.out.println("Cookie maxAge :-"+cookie.getMaxAge());

            context.response().setChunked(true);

            context.response().end("Hello " + cookie.getValue());

        });

        server.requestHandler(router).listen(8080).onComplete(ready->
        {
           if(ready.succeeded())
           {
               System.out.println("server started listening on port no 8080");

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

        vertx.deployVerticle(ManagingCookies.class.getName());
    }


}
