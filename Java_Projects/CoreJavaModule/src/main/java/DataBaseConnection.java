import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DataBaseConnection
{

    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String DB_URL = "jdbc:h2:~/test";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;

    static
    {
        try
        {
            Class.forName(JDBC_DRIVER);  //in static block
        }
        catch ( ClassNotFoundException e )
        {
            e.getMessage();
        }
    }

}
