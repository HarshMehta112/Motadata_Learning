import com.opensymphony.xwork2.ActionSupport;


public class actionCall extends ActionSupport
{

    private String firstName;

    private String lastName;

    private int age;

    private String jsoData;

    private String result;

    public String getResult ()
    {
        return result;
    }

    public void setResult (String result)
    {
        this.result = result;
    }

    public String getFirstName ()
    {

        return firstName;
    }

    public void setFirstName (String firstName)
    {

        this.firstName = firstName;
    }

    public String getLastName ()
    {

        return lastName;
    }

    public void setLastName (String lastName)
    {

        this.lastName = lastName;
    }

    public int getAge ()
    {

        return age;
    }

    public void setAge (int age)
    {

        this.age = age;
    }

    public String getJsoData ()
    {

        return jsoData;
    }

    public void setJsoData (String jsoData)
    {

        this.jsoData = jsoData;
    }

    public String insertDB ()
    {

        Database.insert(this);

        return SUCCESS;
    }

    public String select () throws InterruptedException
    {

//        Thread.sleep(10000);

        result = (Database.select());

        return SUCCESS;
    }


}
