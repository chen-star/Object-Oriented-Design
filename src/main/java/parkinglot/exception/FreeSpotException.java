package parkinglot.exception;

/**
 * @author : alexchen
 * @created : 9/9/20, Wednesday
 **/
public class FreeSpotException extends RuntimeException{

    public FreeSpotException() {
        super("Cannot free up parking spot");
    }
}
