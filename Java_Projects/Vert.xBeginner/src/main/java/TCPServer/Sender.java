package TCPServer;

import io.netty.handler.logging.ByteBufFormat;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;


public class Sender extends AbstractVerticle
{
    public void start()
    {

        NetServer server = vertx.createNetServer(new NetServerOptions().setLogActivity(true)
                .setActivityLogDataFormat(ByteBufFormat.SIMPLE));

        server.connectHandler(socket->
        {
            System.out.println("Local Address :- "+socket.localAddress());

            System.out.println("Remote Address :- "+socket.remoteAddress());

            socket.handler(buffer->
            {
                System.out.println("Received content :- "+buffer.length());

                System.out.println(buffer.getFloat(0));

                System.out.println(buffer.getInt(1));
            });

            socket.write ("Hello all!").onComplete(result->
            {
               if(result.succeeded())
               {
                   System.out.println("Message sent successfully");
               }
               else
               {
                   System.out.println("Some error occurred "+result.cause().getMessage());
               }
            });

        }).listen(8080,"127.0.0.1");
    }
}
