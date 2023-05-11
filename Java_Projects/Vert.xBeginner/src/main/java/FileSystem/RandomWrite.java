package FileSystem;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.file.FileSystem;


public class RandomWrite extends AbstractVerticle
{

    public void start()
    {
        FileSystem fileSystem = vertx.fileSystem();

        fileSystem.readFile("/home/harsh/JavaWork/Vert.xBeginner/Harsh.txt").onComplete(sankalp ->
        {
           if(sankalp.succeeded())
           {
               System.out.println(sankalp.result());
               System.out.println("read success");
           }
           else
           {
               System.out.println("read fail");
           }
        });
    }


}
