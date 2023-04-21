package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BatchUpdatePreparedStatement
{
    static final String DB_URL = "jdbc:h2:~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;


    public static void main (String[] args)
    {
        try
        {
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            String query = "INSERT INTO EMPLOYEE VALUES(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,30);

            preparedStatement.setString(2,"TIRTH");

            preparedStatement.addBatch();

            preparedStatement.setInt(1,31);

            preparedStatement.setString(2,"SNEH");

            preparedStatement.addBatch();

            preparedStatement.executeBatch();


        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }

    }

}
