package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.List;


public class RequestBody extends AbstractVerticle
{

    @Override
    public void start (Promise< Void > startPromise) throws Exception
    {

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        /**
         * as Json Object or as a POJO class
         */
        router.get("/student/add").consumes("application/json").handler(BodyHandler.create()).handler(context ->
        {
            JsonObject studentDetail = context.body().asJsonObject();

            System.out.println(studentDetail);

            System.out.println(studentDetail.getString("name"));
//

//            Student student = context.body().asPojo(Student.class);
//
//            //This will require default constructor as it first creates instance and then uses the getter and setter.
//            System.out.println(student.getId());
//
//            System.out.println(student.getName());

            context.response().setChunked(true);

            context.end("Student added successfully");
        });


        /**
         * SetBodyLimit limits the size of the body
         * if client try to send more than a limit size it gives the
         * 413 error entity is too large
         */

        router.get("/student/add").consumes("text/plain").handler(BodyHandler.create().setBodyLimit(3)).handler(context ->
        {
            System.out.println(context.body().asString());

            context.response().setChunked(true);

            context.end("Student added successfully");

        });

        //buffer

        router.get("/student/add").consumes("text/plain").handler(BodyHandler.create()).handler(context->
        {
            System.out.println(context.body().buffer());

            context.response().setChunked(true);

            context.end("Student added successfully");
        });


        //formAttributes

        /**
         * in the case of formattribute form data is used it is in request only but still
         * it is required to provide bodyhandler.create()
         */

        router.post("/student/add").handler(BodyHandler.create()).handler(context->
        {
            System.out.println("I am in post of formAttributes");

            System.out.println(context.request().formAttributes());

        });


        //Handling File Uploads

        router.post("/student/image").handler(BodyHandler.create().setUploadsDirectory("/home/harsh/Downloads")).handler(context->
        {
            System.out.println("File Uploaded");

            context.response().setChunked(true);

            context.end("File Uploaded");

            List< FileUpload > files = context.fileUploads();

            System.out.println(files.get(0).fileName());
        });



        server.requestHandler(router).listen(8080, ready ->
        {
            if ( ready.succeeded() )
            {
                System.out.println("Server Started Listening!");

                startPromise.complete();
            }
            else
            {
                System.out.println("Fail To Start Server");

                startPromise.fail(ready.cause().getMessage());
            }
        });

    }

    public static void main (String[] args)
    {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(RequestBody.class.getName());
    }


}
