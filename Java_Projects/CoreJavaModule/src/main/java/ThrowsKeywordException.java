import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowsKeywordException {

    void readFile() throws FileNotFoundException
    {
        FileInputStream fis = new FileInputStream("/home/harsh/harsh.txt");
    }
    void writeFile() throws FileNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("home/harsh/harsh.txt");
    }

    public static void main(String[] args) {
        ThrowsKeywordException tke = new ThrowsKeywordException();
        try
        {
            tke.readFile();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}
