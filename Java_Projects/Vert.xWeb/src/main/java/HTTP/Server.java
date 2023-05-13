package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;



public class Server extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(httpServerRequest ->
        {
            HttpServerResponse response = httpServerRequest.response();

            response.putHeader("content-type", "text/plain");

            response.end("Hello Harsh !");

        }).listen(8080,"127.0.0.1").onComplete(handler->
        {
            if(handler.succeeded())
            {
                System.out.println(handler.result());

                startPromise.complete();
            }
            else
            {
                System.out.println(handler.cause().getMessage());

                startPromise.complete();
            }
        });
    }

}
