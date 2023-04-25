package CustomConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;


public class CustomConnectionPool
{

    private String URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";

    private String user = "sa";

    private String password = "";

    private ArrayBlockingQueue< Connection > connectionPool;

    private ArrayList< Connection > activeConnection = new ArrayList<>();

    private final int INITIALPOLLSIZE = 5;

    private final int MAXPOOLSIZE = 10;


    public void setURL (String URL)
    {

        this.URL = URL;
    }

    public void setUser (String USER)
    {

        this.user = user;
    }

    public void setPassword (String password)
    {

        this.password = password;
    }


    public String getURL ()
    {

        return URL;
    }

    public String getUser ()
    {

        return user;
    }

    public String getPassword ()
    {

        return password;
    }

    public int getActiveConnections ()
    {

        return activeConnection.size();
    }

    public int getMaxConnections ()
    {

        return MAXPOOLSIZE;
    }

    public void createConnectionPool ()
    {

        connectionPool = new ArrayBlockingQueue<>(INITIALPOLLSIZE);

        for ( int index = 0; index < INITIALPOLLSIZE; index++ )
        {
            try
            {
                Connection connection = DriverManager.getConnection(URL, user, password);

                connectionPool.add(connection);
            }
            catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    public void createConnectionPool (int size)
    {

        if ( size < MAXPOOLSIZE )
        {
            connectionPool = new ArrayBlockingQueue<>(size);

            for ( int index = 0; index < size; index++ )
            {
                try
                {
                    Connection connection = DriverManager.getConnection(URL, user, password);

                    connectionPool.add(connection);
                }
                catch ( SQLException e )
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            throw new RuntimeException("Please enter pool size appropriately");
        }
    }

    public Connection getConnection ()
    {

        Connection connection = connectionPool.remove();

        activeConnection.add(connection);

        return connection;
    }

    public void releaseConnection (Connection connection)
    {

        try
        {
            connectionPool.put(connection);

            activeConnection.remove(connection);

        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }

    }

}
