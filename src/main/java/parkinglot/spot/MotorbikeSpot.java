package parkinglot.spot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class MotorbikeSpot extends ParkingSpot {
    public MotorbikeSpot(String id) {
        super(id, ParkingSpotType.MOTORBIKE);
    }
}
