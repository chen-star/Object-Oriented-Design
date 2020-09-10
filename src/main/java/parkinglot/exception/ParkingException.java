package parkinglot.exception;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class ParkingException extends RuntimeException{

    public ParkingException() {
        super("Cannot park vehicle");
    }
}
