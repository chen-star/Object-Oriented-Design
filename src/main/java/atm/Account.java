package atm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
@Getter
public abstract class Account {

    private final int accountId;

    @Setter
    private double balance;

    private Card card;

    private double depositLimit;
    private double withdrawLimit;

    public Account(Card card, int accountId, int balance) {
        this.card = card;
        this.accountId = accountId;
        this.balance = balance;
        this.depositLimit = 1000;
        this.withdrawLimit = 1000;
    }
}
