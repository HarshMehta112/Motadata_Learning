package First;

public class Protected extends A{

    public static void main(String[] args) {
        Protected obj=new Protected();
        obj.display();
    }

}

//class B{}

class A {
    protected void display(){
        System.out.println("Hello i am in protected method");
    }
}