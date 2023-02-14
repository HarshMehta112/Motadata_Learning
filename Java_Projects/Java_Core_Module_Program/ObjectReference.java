
class Students
{
    String name;
    Students(String name)
    {
        this.name = name;
    }

    void updateName(String s)
    {
        name = s;
    }

    void show()
    {
        System.out.println("Name is : " +name);
    }
}

public class ObjectReference {

    public static void main(String[] args) {
        Students s1 = new Students("Harsh");
        Students s2 = new Students("Mehta");

        Students s3 = s1;
        s1.updateName("Motadata");
        //s1.show();
        //s3.show();

        s1 = s2;
        s1.show();
        s2.show();
        s3.show();




    }


}
