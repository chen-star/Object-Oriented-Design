package library;

import lombok.Getter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
@ToString
public class Account {

    @Getter
    private final int accountId;


    public Account(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }
}
