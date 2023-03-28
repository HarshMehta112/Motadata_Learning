public class BoxPrimitives {

    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(5); //Boxing
        int primitiveBoxed = boxedInt.intValue(); //unboxing


        String data = "4004 EffectiveJavaProgramming 2007 4.9";

        String[] items = data.split(" ");

        for(String x:items)
        {
            System.out.println(x);
        }

        long id = Long.parseLong(items[0]);
        String ttile = items[1];
        int pulicationyear = Integer.parseInt(items[2]);   // to extract the int value form the string
        double rating = Double.parseDouble(items[3]);


        System.out.println(id);
        System.out.println(ttile);
        System.out.println(pulicationyear);
        System.out.println(rating);


        //boolean isLetter =  Character.isLetter(hash);
        char c = 'a';
        Character ch = c; //Autoboxing

        Character chh = 'a';
        char chhh = chh; // Autounboxing


    }


}
