package CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Operations
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String create()
    {
        String query = "CREATE TABLE ";

        try
        {
            System.out.println("Enter the table name");

            query=query+reader.readLine();

            System.out.println("Enter the column details -- seperated by comma");

            query+="(";

            query+=reader.readLine();

            query+=")";
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        return query;
    }

    public static String insert()
    {
        String query = "INSERT INTO ";

        try
        {
            System.out.println("Enter the table name");

            query=query+reader.readLine()+" VALUES(";

            System.out.println("Enter the values to insert -- seperated by comma");

            query+= reader.readLine();

            query+=")";

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        return query;
    }

    public static String select()
    {
        String query = "SELECT ";

        try
        {
            System.out.println("Enter the table name to display");

            String table = reader.readLine();

            System.out.println("Enter the column name want to display if all then just type 'all'");

            String result = reader.readLine();

            if(result.equalsIgnoreCase("all"))
            {
                query=query+"* ";
            }
            else
            {
                query += result;
            }

            query+="from "+table;

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        return query;
    }

    public static String delete()
    {
        String query = "TRUNCATE TABLE ";

        try
        {
            System.out.println("Enter the table name to truncate");

            query+=reader.readLine();
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        return query;
    }

}
