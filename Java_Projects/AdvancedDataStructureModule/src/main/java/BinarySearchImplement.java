public class BinarySearchImplement
{
    public int binarySearch(int[] arr,int value)
    {
        int start = 0;

        int end = arr.length;

        while(start<end)
        {
            int mid = (start+end)/2;

            if(arr[mid] == value)
            {
                return mid;
            }
            else if (arr[mid]<value)
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int [] arr = {-3,3,4,5,6,7};

        BinarySearchImplement obj = new BinarySearchImplement();

        System.out.println(obj.binarySearch(arr,4));


    }

}
