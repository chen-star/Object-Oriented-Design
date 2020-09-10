package parkinglot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import parkinglot.constants.ParkingSpotType;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
@ToString
public class Ticket {

    @Getter
    private final String id;

    @Getter
    @Setter
    private Instant enterTime;

    @Getter
    @Setter
    private Instant exitTime;

    @Getter
    private final ParkingLevel level;

    @Getter
    private final String spotId;

    @Getter
    private final ParkingSpotType type;


    public Ticket(String id, ParkingLevel level, String spotId, ParkingSpotType type) {
        this.id = id;
        this.level = level;
        this.spotId = spotId;
        this.type = type;
    }
}
