package FileSystem;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;

import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;


public class ExistsAndDelete extends AbstractVerticle
{
    public void start()
    {

        FileSystem fileSystem = vertx.fileSystem();

        Buffer buffer = Buffer.buffer();

        buffer.appendString("Hkejlldv nfdkslvdjf");

        vertx.fileSystem().open("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt",new OpenOptions().setWrite(true)).onComplete(voidAsyncResult -> {

                    if(voidAsyncResult.succeeded())
                    {
                        vertx.fileSystem().writeFile("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt",buffer).onComplete(voidAsyncResult1 -> {
                           if(voidAsyncResult.succeeded())
                           {
                               System.out.println("append successs");
                           }
                           else
                           {
                               System.out.println(voidAsyncResult.cause().getMessage());
                           }
                        });
                        System.out.println("write success");
                    }
                    else
                    {
                        System.out.println("Worte fail ");
                    }

        });
    }

}
