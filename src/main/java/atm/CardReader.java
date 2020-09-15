package atm;

import atm.exception.AuthException;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class CardReader {

    private static CardReader instance = new CardReader();

    private CardReader() {

    }

    public static CardReader getInstance() {
        return instance;
    }

    public void authCheck(Card card, int password) {
        if (card.getPassword() != password) {
            throw new AuthException();
        }
    }
}
