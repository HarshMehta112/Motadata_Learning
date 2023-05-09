package JSON;

import io.vertx.core.json.JsonObject;


public class JsonObjectDemo
{

    public static void main (String[] args)
    {
        String json = "{\"FirstName\" : \"Harsh\", \"LastName\" : \"Mehta\", \"Company\" : \"Motadata\"}";

        System.out.println(json);

        JsonObject jsonObject = new JsonObject(json);

        System.out.println(jsonObject.getString("FirstName"));

        System.out.println(jsonObject.getString("LastName"));

        System.out.println();


    }

}
