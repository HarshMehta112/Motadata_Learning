package HTTP.FileSharing;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;


public class Sender extends AbstractVerticle
{

    public void start (Promise< Void > startPromise)
    {

        vertx.createHttpServer().requestHandler(request ->
        {
            request.response().sendFile("/home/harsh/Downloads/dokumen.pub_vertx-in-action-asynchronous-and-reactive-java-1617295620-9781617295621.pdf");
        }).listen(8080);
    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(Sender.class.getName());
    }

}
