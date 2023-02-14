public class CurrancyConverter {

    int rupee = 63;
    int dirham = 3; // UAE
    int real = 3;  // brazilian
    int chilean_peso = 595;
    int mexican_peso = 18;
    int _yen = 107;
    int $australian = 2;  // australian dollar
    int dollar;
    int Rupee = 63;


    void printCurrencies() {

        System.out.println("rupee: " + rupee);

        System.out.println("$australian: " + $australian);

    }

    public static void main(String[] args) {
        CurrancyConverter cc = new CurrancyConverter();

        cc.printCurrencies();
    }

}
