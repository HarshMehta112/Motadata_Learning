public class Array {

    public static void main(String[] args) {
        int[] arr = new int[4]; //First way of initializaton

        int[] brr = new int[] {10,20,30}; // Second way of initialization

        int[] crr = {50,60,70};

        for(int interator=0;interator<4;interator++)
        {
            arr[interator]=interator;
        }
        for(int iterator:crr)
        {
            System.out.println(iterator);
        }

        System.out.println(arr.length);  //gives the size of the array

    }

}
