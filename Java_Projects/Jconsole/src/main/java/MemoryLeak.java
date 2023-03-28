
import java.util.Map;

public class MemoryLeak {

    public final String key;



    public MemoryLeak(String key) {

        this.key =key;

    }



    public static void main(String args[]) {

        try {

            Map map = System.getProperties();



            for(;;) {

                map.put(new MemoryLeak("key"), "value");

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

    }

}
