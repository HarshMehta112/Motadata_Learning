import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONFileRepresentation
{
    public static void main(String[] args)
    {
        try(FileReader fileReader = new FileReader("/home/harsh/Downloads/FileJason.json"))
        {
            JSONParser jsonParser = new JSONParser();

            Object javaObject = jsonParser.parse(fileReader);

            JSONObject jsonobj = (JSONObject) javaObject;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
