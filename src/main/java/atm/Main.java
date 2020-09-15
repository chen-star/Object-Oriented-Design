package atm;

/**
 * @author : alexchen
 * @created : 9/14/20, Monday
 **/
public class Main {

    public static void main(String[] args) {
        // init
        ATM atm = ATM.getInstance();

        Card card1 = new Card(1, 11, new Customer());
        Account saving1 = new SavingAccount(card1, 1, 1000);
        Account checking1 = new CheckingAccount(card1, 2, 500);
        card1.addAccount(saving1);
        card1.addAccount(checking1);
        Card card2 = new Card(2, 22, new Customer());
        Account saving2 = new SavingAccount(card2, 3, 800);
        Account checking2 = new CheckingAccount(card2, 4, 20);
        card2.addAccount(saving2);
        card2.addAccount(checking2);

        // login
        int token1 = atm.login(card1, 11);
        int token2 = atm.login(card2, 22);

        // balance inquiry
        System.out.println(atm.getBalance(card1, saving1, token1));

        // deposit
        System.out.println(atm.deposit(card1, saving1, token1, 600));
        System.out.println(atm.getBalance(card1, saving1, token1));

        // withdraw
        System.out.println(atm.withdraw(card1, saving1, token1, 200));
        System.out.println(atm.getBalance(card1, saving1, token1));

        // transfer
        System.out.println(atm.transfer(card1, saving1, token1, 150, checking2));
        System.out.println(atm.getBalance(card1, saving1, token1));
        System.out.println(atm.getBalance(card2, checking2, token2));

    }

}
