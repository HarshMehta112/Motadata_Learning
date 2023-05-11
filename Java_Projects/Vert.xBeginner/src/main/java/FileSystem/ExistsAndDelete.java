package FileSystem;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;

import io.vertx.core.file.FileSystem;


public class ExistsAndDelete extends AbstractVerticle
{
    public void start()
    {

        FileSystem fileSystem = vertx.fileSystem();

        vertx.fileSystem().writeFile("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt",
                Buffer.buffer("Hello Harsh! How are you?")).onComplete(voidAsyncResult -> {

                    if(voidAsyncResult.succeeded())
                    {
                        System.out.println("write success");
                    }
                    else
                    {
                        System.out.println("Worte fail ");
                    }

        });
    }

}
