import java.util.*;

public class HashSetInJava
{
    public static void main(String[] args)
    {

        Set<Integer> set = new HashSet<>();

        set.add(2);

        set.add(5);

        set.add(6);

        set.add(8);

        System.out.println(set);

        //Iterating over the set

        Set<String> programmingLanguages = new HashSet<>();

        programmingLanguages.add("C");

        programmingLanguages.add("C++");

        programmingLanguages.add("Java");

        programmingLanguages.add("Python");

        programmingLanguages.add("PHP");

        programmingLanguages.add("Ruby");

//        programmingLanguages.forEach(x-> System.out.println(x));

//        Iterator<String> iterator = programmingLanguages.iterator();
//
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//
//            //iterator = iterator.next();
//        }

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("harsh");

        treeSet.add("sankalp");

        treeSet.add("mehta");

        treeSet.add("Nikunj");

//        treeSet.addAll();

//        System.out.println(treeSet.ceiling("meta"));

//        System.out.println(treeSet.descendingSet());

        System.out.println(treeSet);

//        System.out.println(treeSet.headSet("mehta",true));

        System.out.println(treeSet.higher("mehta"));

    }
}
