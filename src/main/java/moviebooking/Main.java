package moviebooking;

import java.time.Instant;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
public class Main {

    public static void main(String[] args) {
        BookingSystem bookingSystem = BookingSystem.getInstance();

        // init
        Account account1 = new Account(1, "Alex");

        Movie movie1 = new Movie(1, "Love", 100);
        Movie movie2 = new Movie(2, "Hello World", 100);
        Movie movie3 = new Movie(3, "Wall Street", 100);
        movie1.setGenre(Genre.Romantic);
        movie2.setGenre(Genre.Romantic);
        movie3.setGenre(Genre.Story);
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);
        bookingSystem.addMovie(movie3);

        Cinema c1 = new Cinema(1, "C1");
        Hall h1 = new Hall(1, c1, 10);

        Show show1 = new Show(1, movie1, Instant.now(), Instant.now(), c1, h1);
        Show show2 = new Show(2, movie1, Instant.now(), Instant.now(), c1, h1);
        movie1.addShow(show1);
        movie1.addShow(show2);

        // search by genre
        System.out.println(bookingSystem.searchByGenre(Genre.Romantic.toString()));


        // book
        List<Show> shows = bookingSystem.getAvailableShows(account1.getUserId(), 1);
         // expect 2
        System.out.println(shows.size());
         // expect empty list
        System.out.println(bookingSystem.getAvailableShows(account1.getUserId(), 3));

        List<Seat> seats = bookingSystem.getAvailableSeats(account1.getUserId(), shows.get(0));
         // expect 10
        System.out.println(seats.size());

        Ticket ticket = bookingSystem.makeABooking(account1.getUserId(), 1, shows.get(0), seats.get(1));
        System.out.println(ticket);
         // expect 9
        System.out.println(bookingSystem.getAvailableSeats(account1.getUserId(), shows.get(0)).size());


        // cancel
        bookingSystem.cancel(ticket);
          // expect 10
        System.out.println(bookingSystem.getAvailableSeats(account1.getUserId(), shows.get(0)).size());
    }
}
