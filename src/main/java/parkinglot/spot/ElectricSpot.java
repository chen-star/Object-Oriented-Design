package parkinglot.spot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class ElectricSpot extends ParkingSpot {
    public ElectricSpot(String id) {
        super(id, ParkingSpotType.ELECTRIC);
    }
}
