class Adress {
    String city,country,state;

    public Adress(String city, String state,String country)
    {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}


public class Agregration {

    Adress adress;
    Agregration(String name, Adress adress)
    {
        //this.name = name;
        this.adress = adress;
    }

}
