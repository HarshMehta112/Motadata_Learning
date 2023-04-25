package CRUD2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.SortedMap;


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

                try
                {
                    System.out.println("Enter the table name");

                    String tableName=reader.readLine();

                    System.out.println("Enter the column details -- seperated by comma");

                    String columnNames=reader.readLine();

                    executeQuery=CRUD2.Operations.create(tableName,columnNames);

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }


                break;
            }

            case 2:
            {
                try
                {
                    System.out.println("Enter the table name");

                    String tableName=reader.readLine();

                    System.out.println("Enter the values to insert -- seperated by comma");

                    String columnName= reader.readLine();

                    executeQuery=CRUD2.Operations.insert(tableName,columnName);

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
                break;
            }

            case 3:
            {
                try
                {
                    System.out.println("Enter the table name to display");

                    String table = reader.readLine();

                    System.out.println("Enter the column name want to display if all then just type 'all'");

                    String result = reader.readLine();

                    executeQuery=CRUD2.Operations.select(table,result);
                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
                break;
            }

            case 4:
            {
                try
                {
                    System.out.println("Enter the table name to truncate");

                    String tableName=reader.readLine();

                    executeQuery=CRUD2.Operations.delete(tableName);

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
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
