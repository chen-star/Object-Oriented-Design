package moviebooking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@Getter
public class Movie {

    private final int movieId;

    private final String movieName;

    private int duration;

    @Setter
    private Genre genre;

    @Setter
    private List<Show> shows;


    public Movie(int movieId, String movieName, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public String toString() {
        return movieId + " " + movieName + " " + genre;
    }
}
