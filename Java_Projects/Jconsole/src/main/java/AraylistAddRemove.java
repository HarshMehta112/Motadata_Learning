import java.util.ArrayList;
import java.util.List;


public class AraylistAddRemove
{

    public static void main (String[] args)
    {

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10000;i++)
        {
            list.add(i+1);

//            if(list.size()>=5000)
//            {
//                for(int j=0;j<500;j++)
//                {
//                    list.remove(j+1);
//                }
//            }
        }
    }

}
