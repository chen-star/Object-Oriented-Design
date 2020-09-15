package atm.transaction;

import atm.Account;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class TransferTransaction extends Transaction {

    private final Account toAccount;

    public TransferTransaction(int transactionId, Instant timestamp, double amount,
                               Account fromAccount, Account toAccount) {
        super(transactionId, timestamp, amount, fromAccount);
        this.toAccount = toAccount;
    }
}
