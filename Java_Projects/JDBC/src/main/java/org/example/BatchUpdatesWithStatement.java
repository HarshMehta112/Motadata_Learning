package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BatchUpdatesWithStatement
{
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;





    public static void main (String[] args) throws SQLException
    {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = connection.createStatement();

        try
        {


//            connection.setAutoCommit(false);

            statement.addBatch("INSERT INTO EMPLOYEE VALUES(9,'DHAVAL')");

            statement.addBatch("INSERT INTO EMPLOYEE VALUES(10,'SHEKHAR')");

            statement.addBatch("INSERT INTO EMPLOYEE VALUES(11,'PAVAN')");

            statement.addBatch("DELETE FROM EMPLOYEE WHERE EMPNO=455");


            for(int i=0;i<1000;i++)
            {
                int id = i;
                statement.addBatch("INSERT INTO EMPLOYEE VALUES('"+id+"','RAHIL')");
            }


            statement.executeBatch();


        }
        catch ( Exception exception )
        {
//            try
//            {
//                connection.rollback();
//            }
//            catch ( SQLException e )
//            {
//                throw new RuntimeException(e);
//            }

            exception.printStackTrace();
        }
        finally
        {

        }
    }
}
