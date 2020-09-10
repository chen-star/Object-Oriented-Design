package parkinglot.spot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class LargeSpot extends ParkingSpot {
    public LargeSpot(String id) {
        super(id, ParkingSpotType.LARGE);
    }
}
