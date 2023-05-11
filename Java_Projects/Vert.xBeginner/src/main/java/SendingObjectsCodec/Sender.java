package SendingObjectsCodec;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;



public class Sender extends AbstractVerticle
{
    public void start()
    {

        EventBus eventBus = vertx.eventBus();

        String json = "{\"studentName\" : \"Harsh\", \"rollNo\" : 6,\"}";

//        HashMap<String ,String > studentMap = new HashMap<>();
//
//        studentMap.put("studentName","Harsh");
//
//        studentMap.put("studentId","032");

        JsonObject jsonObject = new JsonObject(json);

//        vertx.setTimer(2000,id->
//        {
//            System.out.println("Sending data");
//
//            eventBus.send("student.info",jsonObject);
//
//        });

        vertx.setTimer(3000,id->
        {
            System.out.println("Sending data");

            eventBus.send("student.info",new Student(33,"Mehta"));
        });
    }

}
