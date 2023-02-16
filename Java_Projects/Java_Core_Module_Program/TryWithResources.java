import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TryWithResources {

    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream("harsh.txt"))
        {
            String msg = "Hi Harsh!";

            byte bytearray[] = msg.getBytes();

            if(fos!=null)
            {
                fos.write(bytearray);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        StringBuilder builder = new StringBuilder();

        try(BufferedReader bfr = new BufferedReader(new FileReader("/home/harsh/harsh.txt")))
        {
            String str = null;

            while((str = bfr.readLine()) != null)
            {
                builder.append(str);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println(builder.toString());
    }

}
