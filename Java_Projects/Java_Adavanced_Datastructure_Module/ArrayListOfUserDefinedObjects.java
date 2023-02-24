import java.util.ArrayList;

class Student
{

    private String name;
    private int age;

    Student(String name, int age)
    {
        this.name = name;

        this.age = age;
    }

    public void getData()
    {
        System.out.println("Name of the Student : "+name);

        System.out.println("Age of the student : "+age);
    }

}


public class ArrayListOfUserDefinedObjects
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();

        list.add(new Student("Harsh",22));

        list.add(new Student("Nikunj",22));

        list.add(new Student("Sankalp",22));

//        list.forEach((student)-> student.getData());



    }


}
