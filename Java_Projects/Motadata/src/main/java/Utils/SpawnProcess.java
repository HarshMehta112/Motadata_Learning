package Utils;

import io.vertx.core.json.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SpawnProcess
{
    public static JsonObject spwanprocess(JsonObject credential){

        String encoder = (Base64.getEncoder().encodeToString((credential).toString().getBytes(StandardCharsets.UTF_8)));

        BufferedReader reader = null;

        Process process = null;

        JsonObject result = null;

        try
        {
            ProcessBuilder builder = new ProcessBuilder(Constants.PLUGIN_PATH,encoder);

            System.out.println(builder.command());

            process= builder.start();

            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null)
            {
                result = new JsonObject(line);
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return result;
    }
}
