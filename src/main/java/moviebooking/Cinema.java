package moviebooking;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
@Getter
public class Cinema {

    private final int cinemaId;

    private final String cinemaName;

    private Map<Integer, Hall> hallMap;

    public Cinema(int cinemaId, String cinemaName) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.hallMap = new HashMap<>();
    }

    public void addHall(Hall hall) {
        hallMap.put(hall.getHallId(), hall);
    }
}
