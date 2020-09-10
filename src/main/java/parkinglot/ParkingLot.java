package parkinglot;

import lombok.Getter;
import parkinglot.constants.ParkingSpotType;
import parkinglot.exception.ParkingException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class ParkingLot {

    @Getter
    private final String name;

    @Getter
    private int compactSpotCount = 0;
    @Getter
    private int largeSpotCount = 0;
    @Getter
    private int motorbikeSpotCount = 0;
    @Getter
    private int electricSpotCount = 0;
    @Getter
    private int handicappedCount = 0;

    private final int maxCompactCount;
    private int maxLargeCount;
    private int maxMotorbikeCount;
    private final int maxElectricCount;
    private final int maxHandicappedCount;

    private Map<String, ParkingLevel> parkingFloors;

    private Map<String, Ticket> activeTickets;

    private static ParkingLot instance = new ParkingLot("Alex's ParkingLot");

    private ParkingLot(String name) {
        this.name = name;
        this.maxCompactCount = 4;
        this.maxLargeCount = 8;
        this.maxMotorbikeCount = 0;
        this.maxElectricCount = 0;
        this.maxHandicappedCount = 0;

        this.activeTickets = new HashMap<>();
        this.parkingFloors = new HashMap<>();

        initParkingLot();
    }

    public static ParkingLot getInstance() {
        return instance;
    }

    private void initParkingLot() {
        parkingFloors.put("level1", new ParkingLevel("level1"));
        parkingFloors.put("level2", new ParkingLevel("level2"));
    }

    public Ticket park(ParkingSpotType type) {
        // if full, exception
        isFull(type);

        Ticket ticket = null;
        // if 1st floor is not full
        if (getSpotCount(type, false) / 2 < getSpotCount(type, true)) {
            ticket = parkToFloor(parkingFloors.get("level1"), type);
        } // if 1st floor is full
        else {
            ticket = parkToFloor(parkingFloors.get("level2"), type);
        }

        activeTickets.put(ticket.getId(), ticket);
        adjustSpotCount(type, 1);
        return ticket;
    }

    public double freeUp(Ticket ticket) {
        // set exit time
        ticket.setExitTime(Instant.now());

        // free up spot
        adjustSpotCount(ticket.getType(), -1);
        parkingFloors.get(ticket.getLevel().getId()).free(ticket.getType(), ticket.getSpotId());

        // calc fee
        activeTickets.remove(ticket.getId());
        return Payment.calculateFee(ticket.getEnterTime(), ticket.getExitTime());
    }

    private Ticket parkToFloor(ParkingLevel level, ParkingSpotType type) {
        String spotId = level.park(type);

        // generate ticket
        Ticket ticket = new Ticket(String.valueOf(activeTickets.size()), level, spotId, type);
        ticket.setEnterTime(Instant.now());
        return ticket;
    }

    private int getSpotCount(ParkingSpotType type, boolean isCapacity) {
        switch (type) {
            case COMPACT:
                return isCapacity ? maxCompactCount : compactSpotCount;
            case LARGE:
                return isCapacity ? maxLargeCount : largeSpotCount;
            case MOTORBIKE:
                return isCapacity ? maxMotorbikeCount : motorbikeSpotCount;
            case ELECTRIC:
                return isCapacity ? maxElectricCount : electricSpotCount;
            case HANDICAPPED:
                return isCapacity ? maxHandicappedCount : handicappedCount;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean isFull(ParkingSpotType type) {
        switch (type) {
            case COMPACT:
                return compactSpotCount < maxCompactCount;
            case LARGE:
                return largeSpotCount < maxLargeCount;
            case MOTORBIKE:
                return motorbikeSpotCount < maxMotorbikeCount;
            case ELECTRIC:
                return electricSpotCount < maxElectricCount;
            case HANDICAPPED:
                return handicappedCount < maxHandicappedCount;
            default:
                throw new ParkingException();
        }
    }

    private void adjustSpotCount(ParkingSpotType type, int delta) {
        switch (type) {
            case COMPACT:
                compactSpotCount += delta;
            case LARGE:
                largeSpotCount += delta;
            case MOTORBIKE:
                motorbikeSpotCount += delta;
            case ELECTRIC:
                electricSpotCount += delta;
            case HANDICAPPED:
                handicappedCount += delta;
        }
    }
}
