package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import java.util.Scanner;

public class BlockCode extends AbstractVerticle
{

    public static void main(String[] args)
    {
        System.out.println("Blocking code with scanner...");

        Vertx vertx1 = Vertx.vertx();

        vertx1.deployVerticle(new BlockCode());
    }

    public void start()
    {
        System.out.println("Starting verticle...");
        try
        {
            String input = new Scanner(System.in).nextLine();

            System.out.println("Entered input: " + input);

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            vertx.close();
        }
    }

    public void stop()
    {
        System.out.println("Stopping verticle...");
    }

}