package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class BLOBxample
{

    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;


    public static void main (String[] args)
    {

        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            FileInputStream fileInputStream = new FileInputStream("/root/IdeaProjects/JDBC/src/main/resources/temp.jpg");

            String query = "INSERT INTO IMAGES values(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,101);

            preparedStatement.setBinaryStream(2,fileInputStream);

            preparedStatement.executeUpdate();

            System.out.println("Successful");

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
