package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@Getter
public class Hall {

    private final int hallId;

    private List<Seat> seats;

    private final Cinema cinema;

    public Hall(int hallId, Cinema cinema, int seatCount) {
        this.hallId = hallId;
        this.cinema = cinema;
        initSeat(seatCount);
    }

    private void initSeat(int seatCount) {
        seats = new ArrayList<>();

        for (int i = 0; i < seatCount; i++) {
            seats.add(new Seat(i, this));
        }
    }
}
