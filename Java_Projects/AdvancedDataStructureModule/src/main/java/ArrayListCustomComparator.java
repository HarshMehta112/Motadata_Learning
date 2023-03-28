import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person
{
    private String name;
    private Integer age;

    public Person(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

}

public class ArrayListCustomComparator
{
    public static void main(String[] args)
    {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Harsh", 22));

        people.add(new Person("Nikunj", 32));

        people.add(new Person("Sankalp", 25));

        people.add(new Person("yash", 31));

    }
}