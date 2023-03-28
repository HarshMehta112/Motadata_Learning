import java.util.ArrayList;

public class StreamAPIFilter
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();

        list.add("harsh");

        list.add("hemant");

        list.add("harshKumar");

        list.add("Nikunj");

        list.stream()
                .filter(name->!name.equals("harsh"))

                .forEach(name-> System.out.println(name));


    }
}
