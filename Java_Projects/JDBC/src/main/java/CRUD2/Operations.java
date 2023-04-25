package CRUD2;

public class Operations
{

    public static String create(String tableName,String columnNames)
    {
        String query = "CREATE TABLE "+tableName+"("+columnNames+")";

        return query;
    }

    public static String insert(String tableName,String values)
    {
        String query = "INSERT INTO "+tableName+" "+"values("+ values + ")";

        return query;
    }

    public static String select(String tableName,String columnNames)
    {
        String query = "SELECT "+columnNames+" "+"FROM "+tableName;

        return query;
    }

    public static String delete(String tableName)
    {
        String query = "TRUNCATE TABLE "+tableName;

        return query;
    }

}
