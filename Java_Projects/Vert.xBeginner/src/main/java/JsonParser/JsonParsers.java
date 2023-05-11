package JsonParser;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.parsetools.JsonParser;

public class JsonParsers
{

    public static void main (String[] args)
    {
        JsonParser parser = JsonParser.newParser();

        parser.handle(Buffer.buffer("[{\"firstName\":\"Bob\","));

        parser.handle(Buffer.buffer("\"lastName\":\"Morane\"},"));

        parser.handle(Buffer.buffer("{\"firstName\":\"Luke\",\"lastName\":\"Lucky\"}"));

        parser.handle(Buffer.buffer("]"));

        parser.end();
    }

}
