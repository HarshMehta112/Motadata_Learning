package FileSystem.AsyncFile;

import io.vertx.core.Vertx;


public class AsyncFileOperations
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(AsyncWrite.class.getName());

        vertx.deployVerticle(AsyncRead.class.getName());

    }
}
