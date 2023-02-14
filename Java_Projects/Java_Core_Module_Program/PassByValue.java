public class PassByValue {

    static void PassByValue(int[] arr)
    {
        arr[1]=3;
    }
    static void show(int[] arr)
    {
        for(int iteratotr : arr)
        {
            System.out.println(iteratotr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,23,445};
        show(arr);
        PassByValue(arr);
        show(arr);
    }

}
