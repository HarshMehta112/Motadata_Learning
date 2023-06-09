
import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesFile
{
    public static String URL;

    public static String USER;

    public static String PASSWORD;



    static void SetDBParameters() throws Exception
    {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("/home/harsh/Project/db.properties");

        properties.load(fileInputStream);

        URL = properties.getProperty("URL");

        USER = properties.getProperty("USER");

        PASSWORD = properties.getProperty("PASSWORD");

    }

}
