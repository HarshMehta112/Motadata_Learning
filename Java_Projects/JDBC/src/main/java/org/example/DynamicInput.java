package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;


public class DynamicInput
{
    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String DB_URL = "jdbc:h2:~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;

    public static void main (String[] args)
    {
        try
        {
            connection  = DriverManager.getConnection(DB_URL,USER,PASS);

            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the Employee ID");

            int Id = Integer.parseInt((reader.readLine()));

            System.out.println("Enter the Employee Name");

            String name = reader.readLine();

            String query = "INSERT INTO EMPLOYEE VALUES("+Id+",'"+name+"')";

//            String query = String.format("insert into employee values(%d,'%s')", Id,name);

            statement.executeUpdate(query);

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
