public class EnhancedForLoop {

    public static void main(String[] args) {

        int[] mark = {67,67,89,87};

        int Max_marks = maximum(mark);

        System.out.println("the maximum score is "+Max_marks);

    }

    public static int maximum(int[] a)
    {
        int max = 0;
        for(int x:a)
        {
            if(x>max)
                max=x;
        }
        return max;
    }

}
