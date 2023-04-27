package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


public class SQLInjection
{

    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;

    public static void main (String[] args)
    {

        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter user name");

            String user = reader.readLine();

            System.out.println("enter password");

            String pass = reader.readLine();

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM USERS WHERE USERS='"+user+"' AND PASSWORD='"+pass+"'";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if ( resultSet.next() )
            {
                System.out.println("Valid Credentials");
            }
            else
            {
                System.out.println("Invalid Credentials");
            }


        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
