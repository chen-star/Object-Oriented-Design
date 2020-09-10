package parkinglot.spot;

import lombok.Getter;
import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class ParkingSpot {

    @Getter
    private String id;

    private boolean free;

    @Getter
    private final ParkingSpotType type;

    public ParkingSpot(String id, ParkingSpotType type) {
        this.id = id;
        this.type = type;
    }

    public boolean isFree() {
        return this.free;
    }

    public boolean park() {
        this.free = false;
        return true;
    }

    public boolean freeUp() {
        this.free = true;
        return true;
    }
}
