import java.util.ArrayList;
import java.util.Collections;

class Students implements Comparable<Students>
{
    private int roolno;

    private String name;

    private int age;

    Students(int roolno, String name, int age)
    {
        this.roolno = roolno;

        this.name = name;

        this.age = age;
    }


    @Override
    public String toString() {
        return name+" | "+age+" | "+roolno;
    }

    @Override
    public int compareTo(Students st)
    {
        if(age==st.age)
            return 0;

        else if(age>st.age)
            return 1;

        else
            return -1;
    }
}






public class ComparableImplement
{
    public static void main(String[] args)
    {
        ArrayList<Students> list = new ArrayList<>();

        list.add(new Students(1,"Harsh",22));

        list.add(new Students(4,"HarshKumar",24));

        list.add(new Students(6,"Nikunj",23));

        list.add(new Students(9,"yash",28));

        Collections.sort(list);

        list.forEach((x)-> System.out.println(x));

    }
}
