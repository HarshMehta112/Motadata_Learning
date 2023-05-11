package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;


public class Client extends AbstractVerticle
{


    public void start(Promise<Void> startPromise)
    {
        HttpClient client = vertx.createHttpClient(new HttpClientOptions());



    }


}
