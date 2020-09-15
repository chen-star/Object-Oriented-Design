package atm.transaction;

import atm.Account;

import java.time.Instant;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class WithdrawTransaction extends Transaction{
    public WithdrawTransaction(int transactionId, Instant timestamp, double amount, Account account) {
        super(transactionId, timestamp, amount, account);
    }
}
