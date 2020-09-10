package parkinglot.spot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class CompactSpot extends ParkingSpot {
    public CompactSpot(String id) {
        super(id, ParkingSpotType.COMPACT);
    }
}
