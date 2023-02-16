import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

public class TryWithMultipleResources {

    public static void main(String[] args) {

        try(FileInputStream file_in_stream = new FileInputStream(new File("/home/harsh/harsh.txt"));

        FileOutputStream file_out_stream = new FileOutputStream(new File("/home/harsh/Harsh.txt")))
        {
            byte bytearray[] = new byte[40];

            file_in_stream.read(bytearray);

            file_out_stream.write(bytearray);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
