package CustomConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionPoolDemo
{

    public static void main (String[] args) throws InterruptedException
    {
        CustomConnectionPool connectionPool = new CustomConnectionPool();

        connectionPool.createConnectionPool(4);

        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                try
                {
                    Connection connection1 = connectionPool.getConnection();

                    PreparedStatement preparedStatement = connection1.prepareStatement("SELECT * FROM PRACTICE");

                    ResultSet resultSet = preparedStatement.executeQuery();

                    System.out.println(Thread.currentThread().getName()+" Active Connections "+ connectionPool.getActiveConnections());

                    while(resultSet.next())
                    {
                        System.out.print(resultSet.getString(1)+"\t");

                        System.out.print(resultSet.getInt(2)+"\t");

                        System.out.println(resultSet.getString(3));

                        System.out.println(" ---------------------------------------------");

                    }
                    connectionPool.releaseConnection(connection1);
                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }

            }
        }).start();

        Thread.sleep(10000);

        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                try
                {
                    Connection connection2 = connectionPool.getConnection();

                    PreparedStatement preparedStatement = connection2.prepareStatement("SELECT * FROM EMPLOYEE");

                    ResultSet resultSet = preparedStatement.executeQuery();

                    System.out.println(Thread.currentThread().getName()+" Active Connections "+connectionPool.getActiveConnections());

                    while(resultSet.next())
                    {
                        System.out.print(resultSet.getString(1)+"\t");

                        System.out.println(resultSet.getString(2));

                        System.out.println("---------------------------------------------");
                    }
                    connectionPool.releaseConnection(connection2);

                    System.out.println(Thread.currentThread().getName()+" Active Connections "+connectionPool.getActiveConnections());

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }

            }
        }).start();



    }

}
