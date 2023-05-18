import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;

import java.util.List;


public class DataBaseConnection
{

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        // JDBC client configuration
        var config = new JsonObject()
                .put("url", "jdbc:h2:tcp://localhost/~/TESTJDBC")
                .put("driver_class", "org.h2.Driver")
                .put("user", "sa")
                .put("password", "");

        var client = JDBCClient.create(vertx, config);

        String query = "SELECT * FROM POLITICIANS";

        client.query(query, resultSetAsyncResult ->
        {
            if ( resultSetAsyncResult.succeeded() )
            {
                List< JsonObject > rows = resultSetAsyncResult.result().getRows();

                System.out.println(resultSetAsyncResult.result().getRows());

                for ( JsonObject row : rows )
                {

//                    System.out.println(row);
                    String columnValue = row.getString("NAME");
//                    System.out.println(columnValue);
                }
            }
            else
            {
                // Handle query failure
                Throwable cause = resultSetAsyncResult.cause();
                cause.printStackTrace();
            }
        });

    }

}
