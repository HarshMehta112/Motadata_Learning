package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;


public class Server extends AbstractVerticle
{
    public void start()
    {

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(httpServerRequest ->
        {
            System.out.println("Absolute URI:- "+httpServerRequest.absoluteURI());

            System.out.println("URI:- "+httpServerRequest.uri());

            System.out.println("Cooki Name:- "+httpServerRequest.getCookie("name"));

            System.out.println("Version:- "+httpServerRequest.version());

            System.out.println("Method:- "+httpServerRequest.method());

            System.out.println("Path:- "+httpServerRequest.path());

            System.out.println("Params:-"+httpServerRequest.params());

            System.out.println("Query:- "+httpServerRequest.query());

            System.out.println("Host:- "+httpServerRequest.host());

            System.out.println("Remote Address:- "+httpServerRequest.remoteAddress());


            httpServerRequest.bodyHandler(buffer ->
            {
                System.out.println("Chunk:-"+buffer.toString());

            });
            httpServerRequest.response().end("Hello all ! ----> 200-OK");

        }).listen(8080,"127.0.0.1").onComplete(httpServerAsyncResult ->
        {
           if(httpServerAsyncResult.succeeded())
           {
               System.out.println("Successfully Started Web Server! ");
           }
           else {
               System.out.println("There is some issue in starting web server " + httpServerAsyncResult.cause().getMessage());
           }

        });

    }

}
