

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class Database {


    static String jdbcURL = "jdbc:h2:tcp://localhost/~/TESTJDBC";

    static String username = "sa";

    static String password = "";


    public static void insert(actionCall actionCall) {


        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);) {

            System.out.println("Connected to H2 database.");

            PreparedStatement pst = connection.prepareStatement("insert  into TASK_TABLE values(?,?,?)");

            pst.setString(1, actionCall.getFirstName());

            pst.setString(2, actionCall.getLastName());

            pst.setInt(3, actionCall.getAge());

            pst.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public static String select() {

        String selectOutput;


        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);) {

            System.out.println("Connected to H2 database.");

            PreparedStatement pst = connection.prepareStatement("select * from TASK_TABLE");

            ResultSet allRows = pst.executeQuery();

            JSONObject json = null;

            JSONArray jsonArray = new JSONArray();

            while (allRows.next())
            {
                json = new JSONObject();

                json.put("name", allRows.getString("FIRST"));

                json.put("email",allRows.getString("LAST"));

                json.put("ally", allRows.getString("AGE"));

                jsonArray.add(json);

            }

            selectOutput = jsonArray.toJSONString();

            System.out.println(selectOutput);

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return selectOutput ;
    }
}