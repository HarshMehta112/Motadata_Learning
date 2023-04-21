package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


public class DateInsetingUsingPreparedStatement
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

            int id = 0;

            while ( true )
            {
                id++;

                System.out.println("Enter the date in dd-mm-yyyy format");

                String dop = reader.readLine();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

                java.util.Date udate = simpleDateFormat.parse(dop);

                long time = udate.getTime();

                java.sql.Date sdate = new java.sql.Date(time);

                preparedStatement.setInt(1,id);

                preparedStatement.setDate(2,sdate);

                preparedStatement.executeUpdate();

                System.out.println("want to again insert please press enter otherwise enter exit");

                if(reader.readLine().equalsIgnoreCase("exit"))
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

