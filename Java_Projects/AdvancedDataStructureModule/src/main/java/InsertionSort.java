public class InsertionSort {

    int[] insertionsort(int[] arr)
    {
        int temp = 0,j = 0;

        for(int itr = 0 ; itr<arr.length ; itr++ )
        {
            temp = arr[itr];

            j=itr;

            while(j>0 && arr[j-1]>temp)
            {
                arr[j] = arr[j-1];

                j--;
            }

            arr[j]=temp;

        }
        return arr;
    }


    public static void main(String[] args) {

        InsertionSort obj = new InsertionSort();

        int[] arr = {1,3,4,32,4,3,9};

        obj.insertionsort(arr);

        for(int x:arr)
        {
            System.out.print(x+" ");
        }

    }

}
