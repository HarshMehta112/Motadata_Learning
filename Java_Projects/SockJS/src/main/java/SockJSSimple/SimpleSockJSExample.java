package SockJSSimple;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.net.SocketAddress;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class SimpleSockJSExample extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        SockJSHandler sockJSHandler = SockJSHandler.create(vertx,new SockJSHandlerOptions());

        Router router = Router.router(vertx);

        router.route("/myapp/*").subRouter(sockJSHandler.socketHandler(socket ->
        {
            System.out.println(socket.getClass());

            System.out.println(socket.routingContext().getClass());

            System.out.println(socket.routingContext().request().getClass());

            System.out.println(socket.routingContext().response().getClass());

            socket.write("start");

            socket.handler(handler -> {

                socket.write(handler + "yess!!");

            });

            socket.end();

        }));

        server.requestHandler(router).listen(SocketAddress.inetSocketAddress
                (new InetSocketAddress(InetAddress.getByName("localhost"), 8080)))
                .onComplete(httpServerAsyncResult ->
        {
           if(httpServerAsyncResult.succeeded())
           {
               System.out.println("server started listening on port no 8080");

               startPromise.complete();
           }
           else
           {
               startPromise.fail("Some error occurred "+httpServerAsyncResult.cause().getMessage());
           }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(SimpleSockJSExample.class.getName());
    }

}
