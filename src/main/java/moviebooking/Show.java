package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
@Getter
public class Show {

    private final int showId;

    private final Movie movie;

    private Instant startAt;

    private Instant endAt;

    private Cinema cinema;

    private Hall hall;

    public Show(int showId, Movie movie, Instant startAt, Instant endAt, Cinema cinema, Hall hall) {
        this.showId = showId;
        this.movie = movie;
        this.startAt = startAt;
        this.endAt = endAt;
        this.cinema = cinema;
        this.hall = hall;
    }
}
