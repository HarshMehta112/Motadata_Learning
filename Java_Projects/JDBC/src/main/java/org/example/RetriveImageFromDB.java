package org.example;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RetriveImageFromDB
{

    static final String DB_URL = "jdbc:h2:tcp://localhost/~/TESTJDBC";


    static final String USER = "sa";

    static final String PASS = "";

    static Connection connection = null;


    public static void main (String[] args)
    {

        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "SELECT * FROM IMAGES";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            FileOutputStream fileOutputStream = new FileOutputStream("/home/harsh/DB.jpg");

            if(resultSet.next())
            {
                int name = resultSet.getInt(1);

                InputStream inputStream = resultSet.getBinaryStream(2);

                byte[] buffer = new byte[1024];

                while ( inputStream.read(buffer)>0 )
                {
                    fileOutputStream.write(buffer);
                }
                fileOutputStream.flush();
            }

        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
    }

}
