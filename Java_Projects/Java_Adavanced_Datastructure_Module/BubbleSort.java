public class BubbleSort {

    int[] bubblesort(int[] arr)
    {
        for(int itr = 0; itr < arr.length;itr++)
        {
            boolean flag=false;

            for(int itr1 = 0; itr1 < arr.length-1-itr;itr1++)
            {
                if(arr[itr1]>arr[itr1+1])
                {
                    arr[itr1] = arr[itr1]+arr[itr1+1];

                    arr[itr1+1] = arr[itr1]-arr[itr1+1];

                    arr[itr1] = arr[itr1]-arr[itr1+1];
                }
                flag=true;
            }
            if(!flag)
            {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,4,32,4,3,9};

        BubbleSort obj = new BubbleSort();

        obj.bubblesort(arr);

        for(int x:arr)
        {
            System.out.print(x+" ");
        }

    }

}
