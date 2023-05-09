import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DatabaseInsert extends ActionSupport
{
    private String IP;

    private String name;

    public String getIP ()
    {

        return IP;
    }

    public void setIP (String IP)
    {

        this.IP = IP;
    }

    public String getName ()
    {

        return name;
    }

    public void setName (String name)
    {

        this.name = name;
    }

    private static String URL="jdbc:h2:tcp://localhost/~/TESTJDBC";

    private static String USER="sa";

    private static String PASSWORD="";

    public String insert()
    {
        try( Connection connection = DriverManager.getConnection(URL,USER,PASSWORD) )
        {

            String query = "INSERT INTO TASK_TABLE VALUES (?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,getIP());

            preparedStatement.setString(2,getName());

            preparedStatement.executeUpdate();

            return SUCCESS;
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        return null;
    }
}
