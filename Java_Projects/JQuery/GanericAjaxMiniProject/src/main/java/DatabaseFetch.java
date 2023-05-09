import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class DatabaseFetch extends ActionSupport
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

    private static String URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";

    private static String USER = "sa";

    private static String PASSWORD = "";

    private static List< Map< String, Object > > result = new ArrayList<>();

    public String select ()
    {

        try ( Connection connection = DriverManager.getConnection(URL,USER,PASSWORD) )
        {
            if ( connection != null )
            {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from HOBBIES");

                ResultSet resultSet = preparedStatement.executeQuery();

                while ( resultSet.next() )
                {
                    Map< String, Object > map = new HashMap< String, Object >();

                    map.put("name", resultSet.getString("name"));

                    map.put("email", resultSet.getString("email"));

                    map.put("hobbies", resultSet.getString("hobbies"));

                    result.add(map);
                }

                Gson gson = new Gson();

                JsonArray jArray = gson.toJsonTree(result).getAsJsonArray();

                String jString = jArray.toString();

                System.out.println(jString);

                return jString;
            }

            else
            {
                System.out.println("not connected");
            }

        }

        catch ( Exception exception )
        {
            exception.printStackTrace();
        }

        return null;
    }


}





