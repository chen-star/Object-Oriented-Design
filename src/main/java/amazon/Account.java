package amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
@ToString
public class Account {

    @Getter
    private final int accountId;

    @Getter
    @Setter
    private String accountName;


    public Account(int accountId, String accountName) {
        this.accountId = accountId;
        this.accountName = accountName;
    }
}
