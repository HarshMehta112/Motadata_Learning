// //       11111111111111111111111111111111111111111111111111 (Wrong)
////class Temp
////{
////    public void add (int a,int b)
////    {
////        System.out.println("This is int method");
////        System.out.println("Sum is "+ a+b);
////    }
////
////    public void add (long a,long b)
////    {
////        System.out.println("This is long method");
////        System.out.println("Sum is "+ a+b);
////    }
////
////    public static void main(String[] args) {
////        Temp obj = new Temp();
////        obj.add(10,10);
////    }
////
////}
//
////   2222222222222222222222222222222222222222222222222222222222  (Wrong)
//
////class Temp
////{
////    public static void main(String[] args) {
////
////        try{
////            int[] a = {1,2,3,4,5};
////            int b = a[a.length]/0;
////        }
////        catch(NumberFormatException e)
////        {
////            System.out.println("This is a number exception");
////        }
////        catch (ArithmeticException e)
////        {
////            System.out.println("this is a arithmatic exception");
////        }
////        catch (ArrayIndexOutOfBoundsException e)
////        {
////            System.out.println("The array out of bound exception");
////        }
////        catch(Exception e)
////        {
////            System.out.println("This is normalm exception");
////        }
////
////    }
////}
////
//
//
////  333333333333333333333333333333333333333333333333 (Wrong)
//////
////class Program7
////{
////    void execute() throws Exception
////    {
////        System.out.println(this.getClass()+"Exceute method called");
////    }
////}
////
////class Child extends Program7
////{
////    void execute() throws NumberFormatException {
////        System.out.println(this.getClass()+"excecute method called");
////    }
////
////    public static void main(String[] args) throws Exception {
////        Program7 program7 = new Child();
////        program7.execute();
////    }
////}
//
//
//// 44444444444444444444444444444444444444444444 (Not Attempted)
////class Temp
////{
////    private static void parse(String invalid)
////    {
////        try
////        {
////            Float var =  Float.parseFloat(invalid);
////        }
////        catch (NumberFormatException e)
////        {
////            var = 0;
////        }
////        finally {
////            System.out.println(var);
////        }
////    }
////
////    public static void main(String[] args) {
////        parse("Invalid");
////
////    }
////}
//
//// 5555555555555555555555555555555 (Wrong)
//
////import com.jcraft.jsch.IO;
////
////import java.io.IOException;
//
//
//
//// 6666666666666666666666666666666666666 (None of the above)
//
////class Program9
////{
////    public void excecute()
////    {
////        try
////        {
////            excecute1();
////            System.out.println("Excecute try block");
////        }
////        catch (Exception e)
////        {
////            System.out.println("Excecute method");
////        }
////    }
////    private void excecute1()
////    {
////        excecute2();
////        System.out.println("Excexute method");
////    }
////    private  void excecute2()
////    {
////        excecute3();
////        System.out.println("Excexute 2 method");
////    }
////
////    private void excecute3()
////    {
////        int a = 10/0;
////        System.out.println("Excecute 3 method");
////    }
////
////    public static void main(String[] args) {
////        Program9 obj = new Program9();
////        obj.excecute();
////    }
////
////}
//
//
//// 77777777777777777777777777777 (Wrong) Compile time error
//
////
////class Program7
////{
////    void execute()
////    {
////        System.out.println(this.getClass()+"Exceute method called");
////    }
////}
////
////class Child extends Program7
////{
////    void execute() throws IOException {
////        System.out.println(this.getClass()+"excecute method called");
////    }
////
////    public static void main(String[] args) {
////        Program7 program7 = new Program7();
////        program7.execute();
////    }
////}
////
//
//
////
////
////public class Temp
////{
////    public Temp()
////    {
////        System.out.println("Constructor");
////    }
////    {
////        System.out.println("Blcokn 1");
////    }
////    static
////    {
////        System.out.println("Static block");
////    }
////    {
////        System.out.println("Block 2");
////    }
////
////    public static void main(String[] args) {
////        Temp obj = new Temp();
////
////    }
////}
////
//
//
//// 99999999999999999999999999999999999999999 (Wrong) Five
//
////class Temp
////{
////    public String getX()
////    {
////        return "one";
////    }
////
////    public static void main(String[] args) {
////        Temp obj = new Five();
////        System.out.println(obj.getX());
////    }
////}
////class Two extends Temp
////{
////    public String getX()
////    {
////        return "two";
////    }
////}
////class Three extends Temp
////{
////    public String getX()
////    {
////        return "three";
////    }
////}
////class Four extends Temp
////{
////    public String getX()
////    {
////        return "four";
////    }
////}
////class Five extends Temp
////{
////    public String getX()
////    {
////        return "five";
////    }
////}
//
////
////class Temp
////{
////    public void method(int i)
////    {
////        System.out.println("Value is "+i);
////    }
////}
////
////class Sub extends Temp {
////    public void method(int j) {
////        System.out.println("This value is " + j);
////    }
////
////    public void method(String s) {
////        System.out.println("I am passed " + s);
////    }
////
////    public static void main(String[] args) {
////        Temp obj = new Temp();
////        Temp obj1 = new Sub();
////        obj.method(5);
////        obj1.method(6);
////    }
////}
//
////
////
//
//
//////
//////
//////}
////
////      (Right)
//
////class Temp{
////
////    public void display(String...s,int x)
////    {
////        System.out.println(s[s.length-x]);
////    }
////
////    public static void main(String[] args) {
////
////        Temp obj = new Temp();
////        obj.display("Hi",1);
////        obj.display("Hi","Nilesh",2);
////    }
////
//
//
////       Wrong
////class Temp
////{
////    public void excecute()
////    {
////        try
////        {
////            int a=10/0;
////        }
////        finally {
////            System.out.println("This block will not excecute");
////        }
////    }
////
////    public static void main(String[] args) {
////        Temp obj = new Temp();
////        obj.excecute();
////    }
////}
////
////import java.io.BufferedReader;
////
////import java.io.IOException;
////
////import java.io.InputStream;
////
////import java.io.InputStreamReader;
////
////import com.jcraft.jsch.Channel;
////
////import com.jcraft.jsch.ChannelExec;
////
////import com.jcraft.jsch.JSch;
////
////import com.jcraft.jsch.Session;
////
////public class SSHConnection {
////
////    private static String ip_address;
////
////    private static String user_name;
////
////    private static String user_password;
////
////    private static String command;
////
////    public void setData() throws IOException
////    {
////
////        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
////
////        System.out.println("Enter IP address to connect");
////
////        ip_address = "10.20.40.156"; //bfr.readLine();
////
////        System.out.println("Enter user name to connect");
////
////        user_name = "hemant"; //bfr.readLine();
////
////        System.out.println("Enter user password to connect");
////
////        user_password = "Reo@1234"; //bfr.readLine();
////
////        System.out.println("Enter command to run");
////
////        command = "top -b -n 1"; //bfr.readLine();
////
////    }
////
////    public static void main(String[] args) throws IOException
////    {
////
////        SSHConnection ssh = new SSHConnection();
////
////        ssh.setData();
////
////        try
////        {
////            java.util.Properties config = new java.util.Properties();
////
////            config.put("StrictHostKeyChecking", "no");
////
////            JSch jsch = new JSch();
////
////            Session session=jsch.getSession(user_name, ip_address, 22);
////
////            session.setPassword(user_password);
////
////            session.setConfig(config);
////
////            session.connect();
////
////            System.out.println("Connected");
////
////            Channel channel=session.openChannel("exec");
////
////            ((ChannelExec)channel).setCommand(command);
////
////            channel.setInputStream(null);
////
////            ((ChannelExec)channel).setErrStream(System.err);
////
////            InputStream in=channel.getInputStream();
////
////            channel.connect();
////
////            byte[] tmp = new byte[1024];
////
////            while(true)
////            {
////                while(in.available()>0)
////                {
////                    int i=in.read(tmp, 0, 1024);
////
////                    if(i<0)
////                        break;
////
////                    System.out.print(new String(tmp, 0, i));
////                }
////                if(channel.isClosed())
////                {
////                    System.out.println("exit-status: "+channel.getExitStatus());
////
////                    break;
////                }
////
////                try
////                {
////                    Thread.sleep(1000);
////                }
////                catch(Exception e){}
////            }
////            channel.disconnect();
////
////            session.disconnect();
////
////            System.out.println("DONE");
////
////        }
////        catch(Exception e){
////            e.printStackTrace();
////        }
////
////    }
////
////}
//
////
////
////class Message {
////    String msg = "Happy New Year!";
////
////    public void print() {
////        System.out.println(msg);
////    }
////}
////
////public class Test {
////    public static void change(Message m) { //Line n5
////        m = new Message(); //Line n6
////        m.msg = "Happy Holidays!"; //Line n7
////    }
////
////    public static void main(String[] args) {
////        Message obj = new Message(); //Line n1
////        obj.print(); //Line n2
////        change(obj); //Line n3
////        obj.print(); //Line n4
////    }
////}
////Test.java
//
////
////
////class test
////{
////    public void exec()
////    {
////        System.out.println("I am in test");
////    }
////}
////
////class Program7 extends test
////{
////    public void exec(String s)
////    {
////        System.out.println("I am in program7 ");
////    }
////
////    public static void main(String[] args) {
////
////        Program7 obj = new Program7();
////        //obj.exec(4,3);
////        test obj1 = new Program7();
////        obj1.exec("harsh");
////
////
////    }
////
////}
////
////
////
////class test
////{
////
////    public void print(int i)
////    {
////        System.out.println("I am in program7 class");
////    }
////}
//
////class Program7
////{
////    public int print(int i)
////    {
////        System.out.println("I am in test print");
////        return i;
////    }
////
////    public static void main(String[] args) {
////        Program7 obj = new Program7();
////        obj.print(3);
////
////
//// filename Test.java
//// Main.java
////
////class EH
////{
////    public static void main(String[] args) {
////        StringBuffer sb = new StringBuffer("harsh");
////        StringBuffer sb1 = new StringBuffer("harsh");
////        System.out.println(sb==sb1);
////        String s = new String("harsh");
////        String s1 = new String("harsh");
////        System.out.println(s==s1);
////    }
////}
//
////
////class Harsh
////{
////    Harsh()
////    {
////        System.out.println("I am in Harsh Default constructor");
////    }
////    Harsh(int i)
////    {
////        System.out.println("I am in Harsh Parameterized constructor");
////    }
////}
////class Child extends Harsh
////{
////    Child()
////    {
////        System.out.println("I am in Child Default constructor");
////    }
////    Child(int i)
////    {
////        super(i);
////        System.out.println("I am in Child Parameterized constructor");
////    }
////}
////
////class EH
////{
////    public static void main(String[] args) {
////        Harsh hm = new Child(3);
////    }
////}
//
////class Temp
////{
////    int x=4;
////
////    public static void main(String[] args) {
////        Temp obj = new Temp();
////        System.out.println(obj.x);
////    }
////}
//
//class Program7
//{
//    void execute()
//    {
//        System.out.println(this.getClass()+"Exceute method called");
//    }
//}
//
//class Child extends Program7
//{
//    void execute() throws NumberFormatException {
//        System.out.println(this.getClass()+"excecute method called");
//    }
//
//    public static void main(String[] args) {
//        Program7 program7 = new Child();
//        program7.execute();
//    }
//}



class Child
{
    final void execute(int x)
    {
        System.out.println(this.getClass()+"Exceute method called");
    }
    final void execute() {
        System.out.println("Second"+" excecute method called");
    }

    public static void main(String[] args) {
        Child program7 = new Child();
        program7.execute();
    }
}