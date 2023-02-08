public class InstanceOfOperator {
    public static void main(String[] args) {

        Human obj = new Human();
        System.out.println(obj instanceof Human);
    }
}

class Person{}
class Human{}