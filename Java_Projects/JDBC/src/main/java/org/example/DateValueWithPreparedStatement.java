package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DateValueWithPreparedStatement
{


    public static class SQLInjectionPreparedStatement
    {

        static final String DB_URL = "jdbc:h2:~/TESTJDBC";


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

                String query = "SELECT * FROM USERS WHERE USERS=? AND PASSWORD=?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1,user);

                preparedStatement.setString(2,pass);

                 ResultSet resultSet = preparedStatement.executeQuery();

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

}
