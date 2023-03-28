import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderExample {

    public static void main(String[] args) throws IOException {

        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String s = obj.readLine();
        System.out.println(s);


    }



}
