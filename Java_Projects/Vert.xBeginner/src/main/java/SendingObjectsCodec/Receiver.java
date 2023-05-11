package SendingObjectsCodec;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;


public class Receiver extends AbstractVerticle
{
    public void start()
    {

        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("student.info",data->
        {
            Object object = Json.decodeValue(Json.encode(data.body()));

            if(object instanceof JsonObject )
            {
              JsonObject jsonObject = ( JsonObject ) data.body();

                System.out.println(jsonObject.getString("studentName"));
            }
            else
            {
                Student student = (Student) object;

                System.out.println(student.getStudentName());
            }
        });
    }

}
