package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;


public class MultimapFormAttributes extends AbstractVerticle
{
    public void start(Promise<Void> startPromise)
    {

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(httpServerRequest ->
        {
           httpServerRequest.setExpectMultipart(true);

           httpServerRequest.bodyHandler(data->
           {

               System.out.println(data);

               MultiMap formData = httpServerRequest.formAttributes();

               System.out.println(formData);

           });

            httpServerRequest.uploadHandler(file -> {
                System.out.println("Received Some Chunk Of Data:"+file.filename());

                file.streamToFileSystem("/home/harsh/Downloads/dokumen.pub_vertx-in-action-asynchronous-and-reactive-java-1617295620-9781617295621.pdf"+file.filename());
            });

            httpServerRequest.response().send("Done");

            startPromise.complete();

        }).listen(8080);
    }


    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MultimapFormAttributes.class.getName());
    }
}
