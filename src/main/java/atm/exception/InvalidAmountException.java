package atm.exception;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("Invalid Amount Exception");
    }
}
