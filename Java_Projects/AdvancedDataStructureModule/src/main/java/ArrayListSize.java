import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListSize {



    static int findCapacity(ArrayList al) throws Exception {

        Field field = ArrayList.class.getDeclaredField("elementData");

        field.setAccessible(true);

        return ((Object[]) field.get(al)).length;

    }




    static final float LOAD_FACTOR = 0.75F;
    public static void size_grow(ArrayList e)
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

//            curr_capacity = (int) (curr_capacity*LOAD_FACTOR);
        }

//        int new_capacity = (int) ((int) curr_capacity*LOAD_FACTOR);
//
//        curr_capacity+=new_capacity;
//
//        System.out.println(new_capacity);

    }

    public static void main(String[] args) throws Exception {

        ArrayList list = new ArrayList();



        int current  = (int) ((int) list.size()*LOAD_FACTOR);

//        if(list.size()>current)
//        {
//            size_grow(list);
//
//        }

        ArrayListSize.findCapacity(list);


    }


}
