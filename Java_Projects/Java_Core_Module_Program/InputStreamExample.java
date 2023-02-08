import java.io.FileInputStream;
public class InputStreamExample {
    public static void main(String args[]){
        try{
            FileInputStream fin=new FileInputStream("/home/harsh/harsh.txt");
            int i=fin.read();
            System.out.print((char)i);

            fin.close();
        }catch(Exception e){System.out.println(e);}
    }
}