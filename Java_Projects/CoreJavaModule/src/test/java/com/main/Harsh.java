package com.main;
import com.test.*;

public class Harsh {

    public void display()
    {
        System.out.println("I am in com.main package in Harsh Class");
    }

    public static void main(String[] args)
    {

        com.test.Harsh obj = new com.test.Harsh();

        obj.display();
    }

}
