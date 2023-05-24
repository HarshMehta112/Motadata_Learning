
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;

public class MainVerticle extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MainVerticle.class.getName());
    }

    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(req -> {
            if (req.path().equals("/")) {
                req.response().end("<h1>Vert.x Java CRUD</h1>");
            } else if (req.path().startsWith("/update/")) {
                int id = Integer.parseInt(req.path().split("/")[2]);
                JsonObject user = (JsonObject) vertx.sharedData().getLocalMap("users").get(id);
                req.response().end("<input id=\"name\" value=\"" + user.getString("name") + "\">");
            } else if (req.path().startsWith("/delete/")) {
                int id = Integer.parseInt(req.path().split("/")[2]);
                vertx.sharedData().getLocalMap("users").remove(id);
                req.response().end("Deleted");
            }
        });

        server.listen(8080, ar -> {
            if (ar.succeeded()) {
//                startFuture.complete();
            } else {
//                startFuture.fail(ar.cause());
            }
        });
    }

}