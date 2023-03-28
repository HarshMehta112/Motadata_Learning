package Second;
public class Second {
    void display(){
        System.out.println("Hello in second class and package");
    }

    public static void main(String [] args){
//        First obj = new First();
//        obj.display();
        First.First.display();
    }
    }

