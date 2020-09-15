package atm.transaction;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
@ToString
@Getter
public class TransactionDB {

    private static TransactionDB instance = new TransactionDB();

    private TransactionDB() {
        transactionMap = new HashMap<>();
    }

    public static TransactionDB getInstance() {
        return instance;
    }

    private Map<Integer, Transaction> transactionMap;

    public void logATransaction(Transaction transaction) {
        transactionMap.put(transaction.getTransactionId(), transaction);
    }
}
