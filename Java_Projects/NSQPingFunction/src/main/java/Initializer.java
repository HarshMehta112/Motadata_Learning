import javax.servlet.http.HttpServlet;


public class Initializer extends HttpServlet
{

   public void init()
   {
       new Producer();
       Producer.producer.start();
       new Consumer();
   }

}
