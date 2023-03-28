public class TypeCasting {

    public static void main(String[] args) {
        long x = 3;
        int y = (int)x;    //explicit larger to smaller

        int z = 4;
        long w = (int)z;
        //System.out.println(w);
        byte q = 65;
        char c = (char)q;   //both typecasting used byte to short and short to char

        // Loss in implicit typecasting

        int oldval = 1234567890;
        float f = (float) oldval;
        int newval = (int) f;
        System.out.println(f);




    }


}
