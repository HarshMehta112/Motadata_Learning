package TCPServer;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;


public class Receiver extends AbstractVerticle
{
   public void start()
   {
       Buffer buffer = Buffer.buffer().appendFloat(1.23f).appendInt(15);

       NetClient netClient = vertx.createNetClient();

       netClient.connect(8080,"localhost").onComplete(result->
       {
          if(result.succeeded())
          {
              System.out.println("Receiver connected ");

              NetSocket socket = result.result();

              socket.write(buffer).onComplete(result1->
              {
                 if(result1.succeeded())
                 {
                     System.out.println("Message sent successfully");
                 }
              });
              socket.handler(handler->
              {
                  System.out.println("Some data received");

                  System.out.println(handler.getString(0,10));
              });
              socket.closeHandler(v ->
              {
                  System.out.println("The socket has been closed");
              });
          }
          else
          {
              System.out.println("Some error occured in message sent "+result.cause().getMessage());
          }
       });
   }

}
