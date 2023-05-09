import com.opensymphony.xwork2.ActionSupport;


public class Action extends ActionSupport
{
    String firstname;

    String lastname;

    int age;

    String result;


    public String getFirstname ()
    {

        return firstname;
    }

    public void setFirstname (String firstname)
    {

        this.firstname = firstname;
    }

    public String getLastname ()
    {

        return lastname;
    }

    public void setLastname (String lastname)
    {

        this.lastname = lastname;
    }

    public int getAge ()
    {

        return age;
    }

    public void setAge (int age)
    {

        this.age = age;
    }

    public String getResult ()
    {

        return result;
    }

    public void setResult (String result)
    {

        this.result = result;
    }

    public String insert() throws Exception {

        System.out.println("inset called");

        Database.insert(this);

        System.out.println("insert completed");

        return SUCCESS;
    }

    public String select() throws ClassNotFoundException
    {

        System.out.println("select called");

        result = Database.select();

        System.out.println("Result sent ");

        return SUCCESS;
    }

}