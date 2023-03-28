import java.io.*;
public class BufferReader {
    public static void main(String[] args) {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String name;
        try{
            System.out.println("Emter the name");
            name = obj.readLine();
            System.out.println("Enterd name is "+name);
            obj.close();
        }
        catch(Exception e){}
    }
}
