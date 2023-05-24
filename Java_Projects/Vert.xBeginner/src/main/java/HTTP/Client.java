package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;


public class Client extends AbstractVerticle
{


    public void start(Promise<Void> startPromise)
    {
        HttpClient httpClient = vertx.createHttpClient();

        httpClient.request(HttpMethod.GET,8080,"0.0.0.0","/?name=harsh&id=01&passwrod=passwrod").onComplete(httpClientRequestAsyncResult ->
        {
           if(httpClientRequestAsyncResult.succeeded())
           {
               HttpClientRequest request = httpClientRequestAsyncResult.result();

               request.send().onComplete(httpClientResponseAsyncResult ->
               {
                    if(httpClientResponseAsyncResult.succeeded())
                    {
                        System.out.println("Client side response!!!!!");

                        System.out.println(httpClientResponseAsyncResult.result().statusCode());

                        httpClientResponseAsyncResult.result().bodyHandler(buffer->
                        {
                            System.out.println(buffer.toString());

                            startPromise.complete();
                        });
                    }
                    else
                    {
                        System.out.println(httpClientResponseAsyncResult.cause().getMessage());
                    }
               });
           }
           else
           {
               startPromise.fail("Promise Failed");

               httpClientRequestAsyncResult.cause().printStackTrace();

               System.out.println("Some error occurred "+httpClientRequestAsyncResult.cause().getMessage());
           }
        });



    }


}
