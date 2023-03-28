public class QuickSort
{
    int partition (int [] arr, int beg, int end)
    {
        int pivot  = arr[end];

        int i = beg-1;

        for(int j=beg ; j<=end-1; j++)
        {
            if(pivot>arr[j])
            {
                i++;

                int temp = arr[i];

                arr[i] = arr[j];

                arr[j] = temp;
            }
        }
        int temp = arr[i+1];

        arr[i+1] = arr[end];

        arr[end] = temp;

        return i+1;

    }

    void quick(int a[], int start, int end)
    {
        if (start < end)
        {
            int p = partition(a, start, end);

            quick(a, start, p - 1);

            quick(a, p + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,3,4,32,4,3,9};

        QuickSort obj = new QuickSort();

        obj.quick(arr,0, arr.length-1);

        for(int x:arr)
        {
            System.out.print(x+" ");
        }


    }

}
