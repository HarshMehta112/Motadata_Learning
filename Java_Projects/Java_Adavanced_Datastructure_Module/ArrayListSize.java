import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListSize {

    final float LOAD_FACTOR = 0.75F;
    void size_grow(ArrayList e)
    {
        int [] arr = new int[e.size()];

        for(int iterator=0;iterator<e.size();iterator++)
        {
            arr[iterator] = (int) e.get(iterator);
        }

        int curr_capacity = 0;

        if(e.size()<=10)
        {
            curr_capacity = 10;
        }
        else
        {
            curr_capacity = e.size();
        }

        int new_capacity = (int) ((int) curr_capacity*LOAD_FACTOR);

        curr_capacity+=new_capacity;

        System.out.println(new_capacity);

    }

    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        //while(list.size()*LOAD)




    }


}
