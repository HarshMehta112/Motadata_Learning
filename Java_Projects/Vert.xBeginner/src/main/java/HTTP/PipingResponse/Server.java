package HTTP.PipingResponse;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;


public class Server extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(httpServerRequest ->
        {
           httpServerRequest.response().setChunked(true);

           httpServerRequest.pipeTo(httpServerRequest.response());

           startPromise.complete();
        }).listen(8080);
    }

}
