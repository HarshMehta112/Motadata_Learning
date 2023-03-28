public class ExploringMemory
{

    public static void calculate (int calc)
    {

        calc = calc * 100;
    }

    public static void main (String[] args)
    {

        int local = 5;

        calculate(local);

        System.out.println(local);
    }

}
