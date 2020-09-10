package parkinglot;

import lombok.Getter;
import parkinglot.constants.ParkingSpotType;
import parkinglot.exception.FreeSpotException;
import parkinglot.exception.ParkingException;
import parkinglot.spot.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class ParkingLevel {

    @Getter
    private final String id;

    private Map<String, HandicappedSpot> handicappedSpots;
    private Map<String, CompactSpot> compactSpots;
    private Map<String, LargeSpot> largeSpots;
    private Map<String, MotorbikeSpot> motorbikeSpots;
    private Map<String, ElectricSpot> electricSpots;

    public ParkingLevel(String id) {
        this.id = id;
        initLevel();
    }

    // return parking spot id
    public String park(ParkingSpotType type) {
        switch (type) {
            case HANDICAPPED:
                return parkToHandicapped();
            case COMPACT:
                return parkToCompact();
            case LARGE:
                return parkToLarge();
            case MOTORBIKE:
                return parkToMotorBike();
            case ELECTRIC:
                return parkToElectric();
            default:
                throw new ParkingException();
        }
    }

    public void free(ParkingSpotType type, String spotId) {
        switch (type) {
            case HANDICAPPED:
                handicappedSpots.get(spotId).freeUp();
                return;
            case COMPACT:
                compactSpots.get(spotId).freeUp();
                return;
            case LARGE:
                largeSpots.get(spotId).freeUp();
                return;
            case MOTORBIKE:
                motorbikeSpots.get(spotId).freeUp();
                return;
            case ELECTRIC:
                electricSpots.get(spotId).freeUp();
                return;
            default:
                throw new FreeSpotException();
        }
    }

    private String parkToHandicapped() {
        for (Map.Entry<String, HandicappedSpot> entry : handicappedSpots.entrySet()) {
            if (entry.getValue().isFree()) {
                entry.getValue().park();
            }
            return entry.getKey();
        }
        throw new ParkingException();
    }

    private String parkToCompact() {
        for (Map.Entry<String, CompactSpot> entry : compactSpots.entrySet()) {
            if (entry.getValue().isFree()) {
                entry.getValue().park();
            }
            return entry.getKey();
        }
        throw new ParkingException();
    }

    private String parkToLarge() {
        for (Map.Entry<String, LargeSpot> entry : largeSpots.entrySet()) {
            if (entry.getValue().isFree()) {
                entry.getValue().park();
            }
            return entry.getKey();
        }
        throw new ParkingException();
    }

    private String parkToMotorBike() {
        for (Map.Entry<String, MotorbikeSpot> entry : motorbikeSpots.entrySet()) {
            if (entry.getValue().isFree()) {
                entry.getValue().park();
            }
            return entry.getKey();
        }
        throw new ParkingException();
    }

    private String parkToElectric() {
        for (Map.Entry<String, ElectricSpot> entry : electricSpots.entrySet()) {
            if (entry.getValue().isFree()) {
                entry.getValue().park();
            }
            return entry.getKey();
        }
        throw new ParkingException();
    }

    private void initLevel() {
        compactSpots = new HashMap<>();
        compactSpots.put("1a", new CompactSpot("1a"));
        compactSpots.put("1b", new CompactSpot("1b"));

        largeSpots = new HashMap<>();
        largeSpots.put("2a", new LargeSpot("2a"));
        largeSpots.put("2b", new LargeSpot("2b"));
        largeSpots.put("2c", new LargeSpot("2c"));
        largeSpots.put("2d", new LargeSpot("2d"));

        handicappedSpots = new HashMap<>();
        motorbikeSpots = new HashMap<>();
        electricSpots = new HashMap<>();
    }
}
