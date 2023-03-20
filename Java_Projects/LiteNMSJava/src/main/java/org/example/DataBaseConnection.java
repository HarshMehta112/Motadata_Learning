package org.example;

import java.sql.*;

public class DataBaseConnection
{

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";


    static final String USER = "sa";
    static final String PASS = "";

    Connection connection = null;

    static
    {
        try
        {
            Class.forName(JDBC_DRIVER);  //in static block
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void DBDataFetch()
    {

        Statement statement = null;

        try
        {

//            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

//            System.out.println("Creating table in given database...");

            statement = connection.createStatement();

//            String queryForPollingTable = "create table if not exists POLLING_TABLE "+
//                    "(MONITOR_ID Integer not null, "+
//                    "RTT Integer not null, "+
//                    "PACKET_LOSS Integer not null, "+
//                    "STATUS varchar(4), "+
//                    "TIME varchar(255))";
//
//            statement.executeUpdate(queryForPollingTable);


//            String queryForTableCreation = "create table if not exists Monitor_Table "+
//                    "(Monitor_ID Integer not null, "+
//                     "IP_Address varchar(15))";
//
//            statement.executeUpdate(queryForTableCreation);
//
//            String query = "insert into Monitor_Table "+ "Values (1,'localhost')";
//            statement.executeUpdate(query);
//
//            query = "insert into Monitor_Table "+ "Values (2,'8.8.8.8')";
//            statement.executeUpdate(query);
//
//
//            query = "insert into Monitor_Table "+ "Values (3,'10.20.40.199')";
//            statement.executeUpdate(query);
//
//
//            query = "insert into Monitor_Table "+ "Values (4,'google.com')";
//            statement.executeUpdate(query);


            String query = "select IP_ADDRESS FROM MONITOR_TABLE";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                String IPAdress = resultSet.getString("IP_ADDRESS");

                PingUtility pingObject = new PingUtility();

                pingObject.Ping(IPAdress);

                String queryForDump="";

                queryForDump = "insert into POLLING_TABLE VALUES (?,?,?,?,?)";

                PreparedStatement preparedStatement = connection.prepareStatement(queryForDump);

                preparedStatement.setString(1,IPAdress);

                preparedStatement.setDouble(2,(pingObject.getRTT()));

                preparedStatement.setString(3,pingObject.getPacketLoss());

                preparedStatement.setString(4, pingObject.getStatus());

                preparedStatement.setString(5, pingObject.getTime());

                preparedStatement.executeUpdate();

                preparedStatement.close();

//                System.out.println(s);
            }

//            System.out.println("Created table in given database...");

            statement.close();

            connection.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (statement != null)

                    statement.close();
            }
            catch (SQLException se2)
            {
                se2.printStackTrace();
            }
            try
            {
                if (connection != null) connection.close();
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }

//        System.out.println("Goodbye!");
        }
    }
}