package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import io.vertx.core.json.JsonObject;

public class HarshSSH {

    public static void spwanprocess(JsonObject credential){

        String encoder = (Base64.getEncoder().encodeToString((credential).toString().getBytes(StandardCharsets.UTF_8)));

//        String encoder = credential.toString();

        BufferedReader reader = null;

        Process process = null;

        try
        {
            ProcessBuilder builder = new ProcessBuilder("/home/harsh/Documents/BootStrapHarsh",encoder);

            System.out.println(builder.command());

            process= builder.start();

            JsonObject jsonObject = new JsonObject();

            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static void main(String[] args) {

        JsonObject data = new JsonObject();

        data.put("username", "harsh");

        data.put("password","code@112");

        data.put("port",22);

        data.put("ip","10.20.40.199");

//        System.out.println(data.encode());

        spwanprocess(data);

    }


}
