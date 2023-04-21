package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


public class DateInsertWithDTF
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

            String query = "INSERT INTO DATES VALUES(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int id = 10;

            while ( true )
            {
                id++;

                System.out.println("Enter the date in yyyy-mm-dd format");

                String dop = reader.readLine();

                java.sql.Date time = java.sql.Date.valueOf(dop);

                preparedStatement.setInt(1, id);

                preparedStatement.setDate(2, time);

                preparedStatement.executeUpdate();

                System.out.println("want to again insert please press enter otherwise enter exit");

                if ( reader.readLine().equalsIgnoreCase("exit") )
                {
                    break;
                }
            }

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
