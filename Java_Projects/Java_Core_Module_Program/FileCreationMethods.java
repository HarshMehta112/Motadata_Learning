import java.io.File;
import java.io.IOException;

// 2 ways 1. using File class and 2. using FileOutputStreamClass
public class FileCreationMethods {

    public static void main(String[] args) throws IOException {
        String path = "/home/harsh";
        String name = "Mehta.txt";

        File obj = new File(path,name);
        obj.createNewFile();
    }



}
