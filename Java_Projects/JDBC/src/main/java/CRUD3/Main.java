package CRUD3;

import java.sql.*;
import java.util.*;


public class Main
{
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;



    public static void main (String[] args) throws SQLException
    {
        connection = DriverManager.getConnection(DB_URL,USER,PASS);

//        HashMap<String,Object> map = new HashMap<>();

//        map.put("PERSONID",97);

//        map.put("FIRSTNAME","Sankalp");

        Operations operations = new Operations(connection);

        ArrayList<String> colums = new ArrayList<>();

        colums.add("STATUS");

        colums.add("IP");

//        operations.update("PERSONS",map,"FIRSTNAME='Sankalp'");

//        operations.delete("ORDERS","ORDERID=10308");

        Object[] whereValues = {100};

        System.out.println(operations.select("PRACTICE",colums,"RTT>0"));
    }
}
