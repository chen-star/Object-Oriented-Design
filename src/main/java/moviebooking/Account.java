package moviebooking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
public class Account {

    @Getter
    private final int userId;

    @Setter
    private final String userName;

    public Account(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
