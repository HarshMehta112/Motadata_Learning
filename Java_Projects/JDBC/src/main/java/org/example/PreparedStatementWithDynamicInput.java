package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class PreparedStatementWithDynamicInput
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

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int empId=4;

            String empName="";

            while(true)
            {
                empId++;

                System.out.println("Enter the employee name");

                empName = reader.readLine();

                preparedStatement.setInt(1,empId);

                preparedStatement.setString(2,empName);

                preparedStatement.executeUpdate();

                System.out.println("Again to insert.........?");

                if(!reader.readLine().equalsIgnoreCase("yes"))
                {
                    break;
                }

            }
        }
        catch ( Exception exception )
        {
            System.out.println(exception);
        }

    }

}
