package library;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class Payment {

    public static double calcAmount(int actualDays, int overDue) {
        return 2.0 * actualDays + 10.0 * overDue;
    }
}
