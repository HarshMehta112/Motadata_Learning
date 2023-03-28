import java.io.File;

public class FileOperations {

    public static void main(String[] args) {

        File f = new File("/home/harsh/Harsh.txt");
        System.out.println("File name "+f.getName());
        System.out.println("Absolute path "+ f.getAbsolutePath());
        System.out.println("Parent:" + f.getParent());
        System.out.println("Exists :" + f.exists());
        System.out.println("Readable:" + f.canRead());
        System.out.println("Writable :" + f.canWrite());
    }

}
