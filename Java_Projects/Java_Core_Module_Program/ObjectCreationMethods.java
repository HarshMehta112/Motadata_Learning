import java.lang.*;
public class ObjectCreationMethods implements Cloneable  {

    String name="";
    void setname(String s)
    {
        name = s;
    }
    void getname()
    {
        System.out.println(name);
    }

    public static void main(String[] args) {
        //ObjectCreationMethods obj = new ObjectCreationMethods(); // First method
        try {
            ObjectCreationMethods obj = new ObjectCreationMethods();
            obj.setname("Harsh");
            ObjectCreationMethods obj2 = (ObjectCreationMethods) obj.clone();
            obj2.getname();
        }
        catch (CloneNotSupportedException e) {

            e.printStackTrace();
        }

    }
}
