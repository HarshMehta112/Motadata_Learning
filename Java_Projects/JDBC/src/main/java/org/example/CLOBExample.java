package org.example;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class CLOBExample
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

            FileReader fileReader = new FileReader("/home/harsh/1GB.bin");

            String query = "INSERT INTO CLOB values(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,101);

            preparedStatement.setCharacterStream(2,fileReader);

            preparedStatement.executeUpdate();

            System.out.println("Successful");

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }


}
