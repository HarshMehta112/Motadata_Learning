package CRUD3;

import java.sql.*;
import java.util.*;


public class Operations
{

    private Connection connection;

    // Constructor
    public Operations (Connection connection)
    {

        this.connection = connection;
    }

    // Insert operation
    public int insert (String tableName, Map< String, Object > data) throws SQLException
    {

        String columns = String.join(",", data.keySet());

        String values = String.join(",", Collections.nCopies(data.size(), "?"));

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            int index = 1;

            for ( Object value : data.values() )
            {
                statement.setObject(index++, value);
            }
            return statement.executeUpdate();
        }
    }

    // Update operation
    public int update (String tableName, Map< String, Object > data, String whereClause) throws SQLException
    {

        String[] columnArray = new String[data.size()];

        int index = 0;

        for ( String column : data.keySet() )
        {
            columnArray[index++] = column + " = ?";
        }

        String setClause = String.join(",", columnArray);

        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + whereClause;

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            int indexs = 1;

            for ( Object value : data.values() )
            {
                statement.setObject(indexs++, value);
            }

            return statement.executeUpdate();
        }
    }


    // Delete operation
    public int delete (String tableName, String whereClause) throws SQLException
    {

        String query = "DELETE FROM " + tableName + " WHERE " + whereClause;

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            return statement.executeUpdate();
        }
    }

    // Select operation
    public List< Map< String, Object > > select (String tableName,ArrayList<String> columnNames, String whereClause) throws SQLException
    {
        String columns = String.join(",", columnNames);

        String query = "SELECT "+ columns +" FROM " + tableName + " WHERE " + whereClause;

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            ResultSet resultSet = statement.executeQuery();

            List< Map< String, Object > > resultList = new ArrayList<>();

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            while ( resultSet.next() )
            {
                Map< String, Object > row = new HashMap<>();

                for ( int j = 1; j <= columnCount; j++ )
                {
                    row.put(metaData.getColumnName(j), resultSet.getObject(j));
                }
                resultList.add(row);
            }
            return resultList;
        }
    }

}
