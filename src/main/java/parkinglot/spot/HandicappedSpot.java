package parkinglot.spot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(String id) {
        super(id, ParkingSpotType.HANDICAPPED);
    }
}
