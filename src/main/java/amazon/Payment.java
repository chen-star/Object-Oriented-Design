package amazon;

import java.util.List;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
public class Payment {

    public static double calcPayment(List<ProductItem> items) {
        double amount = items.stream().mapToDouble(ProductItem::getPrice).sum();
        return amount;
    }

    public static boolean pay(Account account, double amount) {
        System.out.println(amount + " is making payment of " + account);
        return true;
    }
}
