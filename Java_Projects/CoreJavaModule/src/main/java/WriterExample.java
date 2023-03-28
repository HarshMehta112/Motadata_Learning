import java.io.*;
public class WriterExample {
    public static void main(String[] args) {
        try {
            FileWriter w = new FileWriter("/home/harsh/harsh.txt");
            String content = "Moatdata is Networking Company";
            w.write(content);
            w.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}