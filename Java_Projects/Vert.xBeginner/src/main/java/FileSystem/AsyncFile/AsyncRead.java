package FileSystem.AsyncFile;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

import io.vertx.core.buffer.Buffer;


public class AsyncRead extends AbstractVerticle
{

    public void start ()
    {

        vertx.fileSystem()
                .open("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt", new OpenOptions().setRead(true))
                .onComplete(asyncFileAsyncResult ->
                {
                    if ( asyncFileAsyncResult.succeeded() )
                    {
                        AsyncFile file = asyncFileAsyncResult.result();

                        Buffer buffer = Buffer.buffer();

                        for ( int i = 0; i < 5; i++ )
                        {
                            file
                                    .read(buffer, i * 13, i * 13, 13)
                                    .onComplete(ar ->
                                    {
                                        if ( ar.succeeded() )
                                        {
                                            System.out.println(ar.result());
                                            System.out.println("Read ok!-------------------------------------------------------------");
                                        }
                                        else
                                        {
                                            System.err.println("Failed to write: " + ar.cause());
                                        }
                                    });
                        }
                    }
                    else
                    {
                        System.out.println(asyncFileAsyncResult.cause().getMessage());
                    }
                });
    }

}
