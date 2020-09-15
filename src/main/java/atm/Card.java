package atm;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
@ToString
@Getter
public class Card {

    private final int cardNumber;

    private List<Account> accounts;

    private int password;

    private final Customer customer;

    public Card(int cardNumber, int password, Customer customer) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.customer = customer;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
