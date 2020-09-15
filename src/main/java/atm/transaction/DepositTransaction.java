package atm.transaction;

import atm.Account;
import atm.transaction.Transaction;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class DepositTransaction extends Transaction {
    public DepositTransaction(int transactionId, Instant timestamp, double amount, Account account) {
        super(transactionId, timestamp, amount, account);
    }
}
