import java.util.Arrays;

public class SelectionSort
{
    int[] selectionsort(int[] arr)
    {
        int min = 0;

        for(int itr=0;itr<arr.length;itr++)
        {
            min = itr;

            for(int itr1=itr+1;itr1<arr.length;itr1++)
            {
                if(arr[itr1]<arr[min])
                {
                    min = itr1;
                }
            }

            int temp = arr[itr];

            arr[itr] = arr[min];

            arr[min] = temp;

        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,4,32,4,3,9};

        SelectionSort obj = new SelectionSort();

        obj.selectionsort(arr);

        for(int x:arr)
        {
            System.out.print(x+" ");
        }

        Arrays.sort(arr);

    }

}
