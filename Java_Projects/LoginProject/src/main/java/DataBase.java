import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DataBase extends AbstractVerticle {

    static CustomConnectionPool connectionPool;

    static
    {
        connectionPool = CustomConnectionPool.getInstance(4);

        connectionPool.setURL("jdbc:h2:tcp://localhost/~/TESTJDBC");

        connectionPool.setUser("sa");

        connectionPool.setPassword("");

        connectionPool.createConnectionPool();
    }


    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("checkUser", hanlder ->
        {

            JsonObject credentialData = (JsonObject) hanlder.body();

            System.out.println("I am in Database Verticle");

            System.out.println(credentialData);

            if (validationCredentials(credentialData).result())
            {
                hanlder.reply("Valid User");
            }
            else
            {
                hanlder.reply("Invalid User");
            }

        });

    }


    private Future<Boolean> validationCredentials(JsonObject credentialData)
    {
        Promise<Boolean> promise = Promise.promise();

        Connection connection = connectionPool.getConnection();

        try {

            String query="SELECT * FROM USERTABLE WHERE USERNAME=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            String username = credentialData.getString("username");

            String password = credentialData.getString("password");

            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                String dbusername = resultSet.getString(1);

                String dbpassword = resultSet.getString(2);

                if(dbusername.equals(username) && dbpassword.equals(password))
                {
                    promise.complete(true);
                }
                else
                {
                    promise.complete(false);
                }
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();
    }

}
