public class LabelledBreak {

    public static void main(String[] args) {
        outermost: for(int iter=0;iter<=4;iter++)
        {
            for(int iter1=0;iter1<=4;iter1++)
            {
                System.out.println("Hello");
                if(iter==0 && iter1==1)
                {
                    break outermost;
                }
            }
        }
    }


}
