package TCPServer;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.Promise;
import io.vertx.core.net.NetServer;


public class RandomPort extends AbstractVerticle
{
    public void start(Promise<Void> startPromise)
    {

        NetServer server = vertx.createNetServer();

        server.connectHandler(netSocket ->
        {
            System.out.println(netSocket.toString());
        })
                .listen(0,"localhost")
                .onComplete(netServerAsyncResult -> {

                    if(netServerAsyncResult.succeeded())
                    {
                        System.out.println("Server started listening on "+server.actualPort());

                        startPromise.complete();
                    }
                    else
                    {
                        System.out.println("Not able to start the server ");

                        startPromise.fail("Not able to start the server " + netServerAsyncResult.cause().getMessage());
                    }
        });

    }
}
