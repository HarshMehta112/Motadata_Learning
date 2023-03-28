public class MovieBookApp extends Thread {
    static BookTheaterSeat bookTicket;

    int seats;

    @Override
    public void run()
    {
        bookTicket.bookSeat(seats);
    }

    public static void main(String[] args)
    {
        bookTicket = new BookTheaterSeat();

        MovieBookApp harsh = new MovieBookApp();

        harsh.seats = 7;

        harsh.start();

        MovieBookApp nikunj = new MovieBookApp();

        nikunj.seats = 2;

//        try
//        {
//            harsh.join();
//        }
//        catch (InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }

        nikunj.start();

        bookTicket = new BookTheaterSeat();

        MovieBookApp sankalp = new MovieBookApp();

        sankalp.seats = 1;

//        try
//        {
//            nikunj.join();
//        }
//        catch (InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }

        sankalp.start();

        MovieBookApp harshKumar = new MovieBookApp();

        harshKumar.seats = 2;

//        try
//        {
//            sankalp.join();
//        }
//        catch (InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }

        harshKumar.start();

    }

}
