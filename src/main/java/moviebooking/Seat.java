package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@Getter
@ToString
public class Seat {

    private final int seatId;

    private final Hall hall;

    private Set<Show> bookedShows;

    public Seat(int seatId, Hall hall) {
        this.seatId = seatId;
        this.hall = hall;
        bookedShows = new HashSet<>();
    }
}
