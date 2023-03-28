public class InstanceInitializerBlock {

    int x;
    InstanceInitializerBlock(){
        System.out.println("in constructor");
    }

    {
        x=6;
        System.out.println("In instance Initializer block"+x);
    }

    public static void main(String[] args) {
        InstanceInitializerBlock obj = new InstanceInitializerBlock();
    }

}
