import java.io.*;
class OverridenMethodInException{
    void msg() throws Exception {
        System.out.println("parent method");
    }
}

public class TestException extends OverridenMethodInException{
    void msg() throws ArithmeticException {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        OverridenMethodInException p = new TestException();

        try {
            p.msg();
        }
        catch (Exception e){}

    }
}   