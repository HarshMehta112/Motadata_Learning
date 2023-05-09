

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class Database {


    static String jdbcURL = "jdbc:h2:tcp://localhost/~/TESTJDBC";

    static String username = "sa";

    static String password = "";


    public static void insert(Action act) throws ClassNotFoundException
    {

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {

            System.out.println("Connected to H2 database.");

            PreparedStatement pst = connection.prepareStatement("insert  into TASK_TABLE values(?,?,?)");

            pst.setString(1, act.getFirstname());

            pst.setString(2, act.getLastname());

            pst.setInt(3, act.getAge());

            pst.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static String select() throws ClassNotFoundException
    {

        String selectOutput;

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {


            System.out.println("Connected to H2 database.");

            PreparedStatement pst = connection.prepareStatement("select * from TASK_TABLE");

            ResultSet allRows = pst.executeQuery();

            JSONObject json = null;
            JSONArray jsonArray = new JSONArray();

            while (allRows.next())
            {
                json = new JSONObject();

                json.put("firstname", allRows.getString("FIRST"));

                json.put("lastname",allRows.getString("LAST"));

                json.put("age", allRows.getInt("AGE"));

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