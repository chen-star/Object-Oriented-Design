package atm;

import atm.exception.AuthException;
import atm.exception.InvalidAmountException;
import atm.transaction.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class ATM {

    private static ATM instance = new ATM();

    private CardReader cardReader;

    private Map<Integer, Card> sessionMap;

    private TransactionDB transactionDB;

    private Random rd;

    private ATM() {
        cardReader = CardReader.getInstance();
        sessionMap = new HashMap<>();
        transactionDB = TransactionDB.getInstance();
        rd = new Random();
    }

    public static ATM getInstance() {
        return instance;
    }

    /*
     * Login
     */
    public int login(Card card, int password) {
        cardReader.authCheck(card, password);

        int token = rd.nextInt();
        sessionMap.put(token, card);
        return token;
    }

    /*
     * Balance Inquiry
     */
    public double getBalance(Card card, Account account, int token) {
        if (!sessionMap.containsKey(token) || sessionMap.get(token) != card) {
            throw new AuthException();
        }

        return account.getBalance();
    }


    /*
     * Deposit
     */
    public String deposit(Card card, Account account, int token, double amount) {
        if (!sessionMap.containsKey(token) || sessionMap.get(token) != card) {
            throw new AuthException();
        }

        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if (account.getDepositLimit() < amount) {
            throw new InvalidAmountException();
        }

        // update balance
        account.setBalance(account.getBalance() + amount);

        // log transaction
        Transaction transaction = new DepositTransaction(transactionDB.getTransactionMap().size(),
                Instant.now(), amount, account);
        transactionDB.logATransaction(transaction);

        // return receipt
        return account + " deposits " + amount;
    }

    /*
     * Withdraw
     */
    public String withdraw(Card card, Account account, int token, double amount) {
        if (!sessionMap.containsKey(token) || sessionMap.get(token) != card) {
            throw new AuthException();
        }

        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if (account.getBalance() < amount) {
            throw new InvalidAmountException();
        }
        if (account.getWithdrawLimit() < amount) {
            throw new InvalidAmountException();
        }

        // update balance
        account.setBalance(account.getBalance() - amount);

        // log transaction
        Transaction transaction = new WithdrawTransaction(transactionDB.getTransactionMap().size(),
                Instant.now(), amount, account);
        transactionDB.logATransaction(transaction);

        // return receipt
        return account + " withdraws " + amount;
    }

    /*
     * Transfer
     */
    public String transfer(Card card, Account fromAccount, int token, double amount, Account toAccount) {
        if (!sessionMap.containsKey(token) || sessionMap.get(token) != card) {
            throw new AuthException();
        }

        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if (fromAccount.getBalance() < amount) {
            throw new InvalidAmountException();
        }

        // update balance
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // log transaction
        Transaction transaction = new TransferTransaction(transactionDB.getTransactionMap().size(),
                Instant.now(), amount, fromAccount, toAccount);
        transactionDB.logATransaction(transaction);

        // return receipt
        return fromAccount + " transfers " + amount + " to " + toAccount;
    }
}
