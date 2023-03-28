import jdk.jshell.EvalException;

class ThrowAgeException extends RuntimeException
{
    RuntimeException a = new RuntimeException();
    ThrowAgeException(String s) {
//        super(s);

        System.out.println(s);
    }
}

public class ThrowsInCustomException {

    static void validateUser (int age) throws ThrowAgeException
    {
        if(age<18)
        {
            throw new ThrowAgeException("You are not eligible for voting");
        }
        else
        {
            System.out.println("You are eligible for voting");
        }
    }

    public static void main(String[] args) {

        int age = 17;

        try
        {
            validateUser(age);
        }
        catch(ThrowAgeException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
