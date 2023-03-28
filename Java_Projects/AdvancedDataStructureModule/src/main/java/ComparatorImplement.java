import java.util.*;
class ClassStudents
{
    int rollno;
    String name;
    int age;
    ClassStudents(int rollno, String name, int age)
    {
        this.rollno=rollno;

        this.name=name;

        this.age=age;
    }
}
class AgeComparator implements Comparator<ClassStudents>
{
    public int compare(ClassStudents s1, ClassStudents s2)
    {
        if(s1.age==s2.age)
            return 0;

        else if(s1.age>s2.age)
            return 1;

        else
            return -1;
    }
}
class NameComparator implements Comparator<ClassStudents>
{
    public int compare(ClassStudents s1, ClassStudents s2)
    {
        return s1.name.compareTo(s2.name);
    }
}

public class ComparatorImplement
{
        public static void main(String args[])
        {

            ArrayList<ClassStudents> al=new ArrayList<ClassStudents>();

            al.add(new ClassStudents(101,"Vijay",23));

            al.add(new ClassStudents(106,"Ajay",27));

            al.add(new ClassStudents(105,"Jai",21));

            System.out.println("Sorting by Name");

            Collections.sort(al,new NameComparator());

            for(ClassStudents st: al)
            {
                System.out.println(st.rollno+" "+st.name+" "+st.age);
            }

            System.out.println("sorting by Age");

            Collections.sort(al,new AgeComparator());

            for(ClassStudents st: al)
            {
                System.out.println(st.rollno+" "+st.name+" "+st.age);
            }
        }

}
