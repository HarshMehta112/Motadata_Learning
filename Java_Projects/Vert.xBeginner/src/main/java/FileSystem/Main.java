package FileSystem;

import io.vertx.core.Vertx;


public class Main
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(ExistsAndDelete.class.getName());

        vertx.deployVerticle(RandomWrite.class.getName());

    }

}
