package FileSystem.AsyncFile;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;


public class AsyncWrite extends AbstractVerticle
{

    public void start (Promise< Void > startPromise) throws Exception
    {
        vertx.fileSystem()
                .open("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt", new OpenOptions().setRead(true))

                .onComplete(result ->
                {
                    if ( result.succeeded() )
                    {
                        AsyncFile file = result.result();
                        for ( int i = 0; i < 1; i++ )
                        {
                            file
                                    .write(Buffer.buffer("Hello World!+\n"), 13 * i)

                                    .onComplete(ar ->
                                    {
                                        if ( ar.succeeded() )
                                        {
                                            System.out.println("Written ok!");
                                            startPromise.complete();
                                        }
                                        else
                                        {
                                            System.err.println("Failed to write: " + ar.cause());
                                            startPromise.fail(ar.cause().getMessage());
                                        }
                                    });
                        }
                    }
                    else
                    {
                        System.err.println("Cannot open file " + result.cause());
                        startPromise.fail(result.cause().getMessage());
                    }
                });
    }

}
