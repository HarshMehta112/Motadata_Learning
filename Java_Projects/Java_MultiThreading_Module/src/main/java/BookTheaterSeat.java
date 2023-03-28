public class BookTheaterSeat
{
    static int totalSeats=10;

    synchronized void bookSeat(int seats)
    {
        if(totalSeats>=seats)
        {
            System.out.println(Thread.currentThread().getName()+" "+seats+" seats are booked successfully");

            totalSeats -= seats;

            System.out.println("Total left seats : " + totalSeats);
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+" Sorry seats are not booked");

            System.out.println("Total left seats : " + totalSeats);

        }
    }

}

