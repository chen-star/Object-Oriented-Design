package stackoverflow;

import lombok.Getter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/12/20, Saturday
 **/
@ToString
public class Account {

    @Getter
    private int accountId;

    @Getter
    private String name;

    public Account(int accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }
}
