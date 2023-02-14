import java.math.BigDecimal;

public class BasicVarialbePractice {

    public static void main(String[] args) {
        int rank = 12_23;
        System.out.println(rank);

        int minvalue = Integer.MIN_VALUE;
        System.out.println(minvalue);

        float fv = 43.23F;
        double dv = 423.3434D;
        System.out.println(fv);
        System.out.println(dv);

        double discount_value = 1000*(1-0.9);
        System.out.println(discount_value); //999.999999997 we want 100

        BigDecimal first = new BigDecimal("0.2"); //givse exact answer

        char char_in_UTF16 = '\u0042'; // Prints B
        System.out.println(char_in_UTF16);


    }


}
