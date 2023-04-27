package CRUD4;

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


    //insert operation

    public int insert (String tableName, Map< String, Object > data) throws SQLException
    {

        ArrayList< String > columnNames = new ArrayList<>(data.keySet());

        String columns = String.join(",", columnNames);

        String values = String.join(",", Collections.nCopies(data.size(), "?"));

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            int index = 1;

            for ( Object value : columnNames )
            {
                statement.setObject(index++, data.get(value));
            }

            return statement.executeUpdate();

        }
    }


    // Update operation
    public int update (String tableName, Map< String, Object > data, String whereClause) throws SQLException
    {

        ArrayList< String > columnNames = new ArrayList<>(data.keySet());

        String setClause = "";

        for ( int index = 0; index < columnNames.size(); index++ )
        {
            setClause += columnNames.get(index)+"= ?";

            if ( index != columnNames.size() - 1 )
            {
                setClause += ",";
            }
        }

//        ListIterator< String > listIterator = columnNames.listIterator();
//
//        while ( listIterator.hasNext() )
//        {
//            setClause += listIterator.next() + "= ?";
//
//            if ( listIterator.hasNext() )
//            {
//                setClause += ",";
//            }
//        }

        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + whereClause;

        try ( PreparedStatement statement = connection.prepareStatement(query) )
        {
            int indexs = 1;

            for ( String column : columnNames )
            {
                statement.setObject(indexs++, data.get(column));
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
    public List< Map< String, Object > > select (String tableName, ArrayList< String > columnNames,
                                                 String whereClause) throws SQLException
    {

        String columns = String.join(",", columnNames);

        String query = "SELECT " + columns + " FROM " + tableName + " WHERE " + whereClause;

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
