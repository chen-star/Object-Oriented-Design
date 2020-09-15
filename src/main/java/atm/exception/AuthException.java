package atm.exception;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class AuthException extends RuntimeException {

    public AuthException() {
        super("Authentication Exception");
    }
}
