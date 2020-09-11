package library.exception;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class BorrowException extends RuntimeException{

    public BorrowException() {
        super("Borrow Exception");
    }
}
