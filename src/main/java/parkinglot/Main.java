package parkinglot;

import parkinglot.constants.ParkingSpotType;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // park a compact
        Ticket compact1 = parkingLot.park(ParkingSpotType.COMPACT);

        // park a large
        Ticket large1 = parkingLot.park(ParkingSpotType.LARGE);

        // park another large
        Ticket large2 = parkingLot.park(ParkingSpotType.LARGE);

        Thread.sleep(1000);

        // free up large1
        System.out.println("Large1 fee: " + parkingLot.freeUp(large1));
        System.out.println("Large1 ticket: " + large1);

        Thread.sleep(2000);

        // free up compact1
        System.out.println("Compact1 fee: " + parkingLot.freeUp(compact1));
        System.out.println("Compact1 ticket: " + compact1);

        // expect 0
        System.out.println("Compact unavailable spot #: " + parkingLot.getCompactSpotCount());
        // expect 1
        System.out.println("Large unavailable spot #: " + parkingLot.getLargeSpotCount());
    }
}
