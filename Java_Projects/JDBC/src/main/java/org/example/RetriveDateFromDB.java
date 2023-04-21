package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


public class RetriveDateFromDB
{

    static final String DB_URL = "jdbc:h2:~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;


    public static void main (String[] args)
    {

        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM DATES";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() )
            {
                int id = resultSet.getInt(1);

                java.sql.Date date = resultSet.getDate(2);

                String uDate = simpleDateFormat.format(date);

                System.out.println(id+"------------------------ "+uDate);
            }

        }
        catch ( Exception exception )
        {
            System.out.println(exception);
        }
    }


}
