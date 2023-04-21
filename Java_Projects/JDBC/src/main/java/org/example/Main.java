package org.example;

import java.sql.*;


public class Main
{

    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String DB_URL = "jdbc:h2:~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;

    static
    {
        try
        {
//            Class.forName(JDBC_DRIVER);

//            System.out.println(connection.getClass().getName());
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) throws SQLException
    {

        connection = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = connection.createStatement();

        String query = "CREATE TABLE EMPLOYEE (EMPID int, EMPNAME varchar(10))";

        boolean resultSet = statement.execute(query);

    }

}