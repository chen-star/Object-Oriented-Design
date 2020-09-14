package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
@Getter
public class BookingSystem {

    private static BookingSystem instance = new BookingSystem();

    private BookingSystem() {

    }

    public static BookingSystem getInstance() {
        return instance;
    }

    private MovieDB movieDB = MovieDB.getInstance();

    /*
     * Search by Genre
     */
    public List<Movie> searchByGenre(String genreString) {
        Genre genre = Genre.valueOf(genreString);
        return new ArrayList<>(movieDB.getGenreMovieMap().get(genre));
    }


    /*
     * Make a booking
     */
    // Get available Shows
    public List<Show> getAvailableShows(int userId, int movieId) {
        // auth check

        // find all available shows
        return new ArrayList<>(movieDB.getMovieMap().get(movieId).getShows());
    }

    // Get available Seats
    public List<Seat> getAvailableSeats(int userId, Show show) {
        // auth check

        // find all seats
        List<Seat> allSeats = show.getHall().getSeats();

        // find available ones
        return allSeats.stream()
                .filter((seat) -> !seat.getBookedShows().contains(show))
                .collect(Collectors.toList());
    }

    // book
    public Ticket makeABooking(int userId, int movieId, Show show, Seat seat) {
        Ticket ticket = new Ticket(movieDB.getMovieMap().get(movieId), show, show.getHall(), seat, userId);

        // update seat status
        seat.getBookedShows().add(show);

        // make payment

        return ticket;
    }


    /*
     * Cancel a booking
     */
    public void cancel(Ticket ticket) {
        // update seat status
        ticket.getSeat().getBookedShows().remove(ticket.getShow());

        // refund
    }

    public void addMovie(Movie movie) {
        movieDB.addMovie(movie);
    }
}
