package parkinglot;

import java.time.Duration;
import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class Payment {

    public static double calculateFee(Instant enter, Instant exit) {
        Duration duration = Duration.between(enter, exit);
        return (1.0 * duration.getSeconds()) * 4;
    }
}
