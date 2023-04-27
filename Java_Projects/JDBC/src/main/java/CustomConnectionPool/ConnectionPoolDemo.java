package CustomConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionPoolDemo
{

    public static void main (String[] args) throws InterruptedException
    {
        CustomConnectionPool connectionPool = CustomConnectionPool.getInstance(4);

        connectionPool.setURL("jdbc:h2:tcp://localhost/~/TESTJDBC");

        connectionPool.setUser("sa");

        connectionPool.setPassword("");

        connectionPool.createConnectionPool();

        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                Connection connection1 = connectionPool.getConnection();
                try
                {

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

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
                finally
                {
                    connectionPool.releaseConnection(connection1);
                }

            }
        }).start();

        Thread.sleep(5000);

        new Thread(new Runnable()
        {

            @Override
            public void run ()
            {
                Connection connection2 = connectionPool.getConnection();

                try
                {

                    PreparedStatement preparedStatement = connection2.prepareStatement("SELECT * FROM EMPLOYEE");

                    ResultSet resultSet = preparedStatement.executeQuery();

                    System.out.println(Thread.currentThread().getName()+" Active Connections "+connectionPool.getActiveConnections());

                    while(resultSet.next())
                    {
                        System.out.print(resultSet.getString(1)+"\t");

                        System.out.println(resultSet.getString(2));

                        System.out.println("---------------------------------------------");
                    }

                    System.out.println(Thread.currentThread().getName()+" Active Connections "+connectionPool.getActiveConnections());

                }
                catch ( Exception exception )
                {
                    exception.printStackTrace();
                }
                finally
                {
                    connectionPool.releaseConnection(connection2);
                }
            }
        }).start();


    }

}
