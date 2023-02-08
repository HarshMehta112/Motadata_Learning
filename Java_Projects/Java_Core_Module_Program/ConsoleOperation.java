import java.io.Console;
public class ConsoleOperation {

    public static void main(String[] args) {
        Console c = System.console();
        System.out.println("Enter the Name");
        String s = c.readLine();
        System.out.println("Name is "+s);
    }

}
