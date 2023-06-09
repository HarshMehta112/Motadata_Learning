package CRUD4;

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

        Operations operations = new Operations(connection);

        HashMap<String,Object> map = new HashMap<>();

        map.put("EMPNO",97);

        map.put("EMPNAME","VIRAMSIR");

        operations.insert("EMPLOYEE",map);

        ArrayList<String> colums = new ArrayList<>();

        colums.add("STATUS");

        colums.add("IP");

        System.out.println(operations.select("PRACTICE",colums,"RTT>0"));

        operations.update("EMPLOYEE",map,"EMPNAME='Sankalp'");

        operations.delete("ORDERS","ORDERID=10308");

    }
}
