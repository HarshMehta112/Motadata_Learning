public class ObjectInitialization {

    String name;
//    ObjectInitialization(String s){
//        name = s;
//    }
    void setname(String s)
    {
        name = s;
    }
    void getname(){
        System.out.println("Name is "+name);
    }

    public static void main(String[] args) {
//        ObjectInitialization obj = new ObjectInitialization("Mehta");
        ObjectInitialization obj1 = new ObjectInitialization();
        obj1.name = "Harsh";


        //obj.setname("Harsh");
//        obj.getname();
    }



}
