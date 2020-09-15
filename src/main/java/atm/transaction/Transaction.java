package atm.transaction;

import atm.Account;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
@ToString
@Getter
public abstract class Transaction {

    private final int transactionId;

    private Instant timestamp;

    private double amount;

    private Account account;


    public Transaction(int transactionId, Instant timestamp, double amount, Account account) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.account = account;
    }
}
