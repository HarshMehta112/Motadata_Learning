package org.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;


public class SavePointExample
{

    static Connection connection = null;


    public static void main (String[] args) throws Exception
    {

        PropertiesFile.SetDBParameters();

        try
        {
            Properties properties = new Properties();

            FileInputStream fileInputStream = new FileInputStream("/home/harsh/Project/db.properties");

            properties.load(fileInputStream);

            connection = DriverManager.getConnection(PropertiesFile.URL, properties);

            connection.setAutoCommit(false);

            System.out.println(connection.getTransactionIsolation());

            connection.setTransactionIsolation(8);

            System.out.println(connection.getTransactionIsolation());

            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO POLITICIANS VALUES ('MODI','BJP')");

            statement.executeUpdate("INSERT INTO POLITICIANS VALUES ('KEJRIWAL','AAP')");

            Savepoint savepoint = connection.setSavepoint();

            statement.executeUpdate("INSERT INTO POLITICIANS VALUES ('GANDHI','CONGRESS')");

            connection.rollback(savepoint);

            connection.commit();
        }
        catch ( Exception exception )
        {
            connection.commit();
            exception.printStackTrace();
        }

    }

}
