package CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main
{
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static Connection connection = null;

    public static void main (String[] args) throws IOException
    {
        System.out.println("1. Create the Table");

        System.out.println("2. Insert the the table");

        System.out.println("3. Read the data from the table ");

        System.out.println("4. remove the data from the table");

        String executeQuery = "";

        int operations = Integer.parseInt(reader.readLine());


        switch ( operations )
        {

            case 1:
            {
                executeQuery=Operations.create();
                break;
            }

            case 2:
            {
                executeQuery=Operations.insert();
                break;
            }

            case 3:
            {
                executeQuery=Operations.select();
                break;
            }

            case 4:
            {
                executeQuery=Operations.delete();
            }
        }
        try
        {
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(executeQuery);

            boolean answer = preparedStatement.execute();

            if(answer==true)
            {
                ResultSet resultSet = preparedStatement.getResultSet();

                while ( resultSet.next() )
                {

                }

            }
            else
            {
                System.out.println("Total "+preparedStatement.getUpdateCount() + " rows are updated");
            }


        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
