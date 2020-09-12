package amazon;

import amazon.exception.CheckoutException;
import amazon.exception.SearchException;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
@ToString
public class Amazon {

    @Getter
    private Map<Integer, Category> categoryMap;

    @Getter
    private Map<Account, ShoppingCart> shoppingCartMap;

    private Random random;

    public Amazon() {
        categoryMap = new HashMap<>();
        shoppingCartMap = new HashMap<>();
        random = new Random();
    }

    /*
     * Search by Category
     */
    public List<Product> searchByCategory(int categoryId) {
        if (!categoryMap.containsKey(categoryId)) {
            throw new SearchException();
        }

        Category category = categoryMap.get(categoryId);
        return category.getProducts();
    }

    /*
     * Add an item into shopping cart
     */
    public void addShoppingCart(Account account, ProductItem item) {
        // auth check
        // if failed, throw AuthException

        if (!shoppingCartMap.containsKey(account)) {
            shoppingCartMap.put(account, new ShoppingCart(new ArrayList<>()));
        }
        shoppingCartMap.get(account).addAnItem(item);
    }

    /*
     * Check out
     */
    public Order checkout(Account account) {
        if (!shoppingCartMap.containsKey(account)) {
            throw new CheckoutException();
        }

        ShoppingCart shoppingCart = shoppingCartMap.get(account);
        double amount = Payment.calcPayment(shoppingCart.items);

        // make payment
        System.out.println("Please make payment of amount: " + amount);

        // clear shopping carts
        List<ProductItem> productItems = shoppingCart.items;
        shoppingCartMap.remove(account);

        // make order
        int orderId = random.nextInt();
        Order order = new Order(orderId, productItems, amount, account);
        return order;
    }

    public Map<Integer, Category> getCategoryMap() {
        return categoryMap;
    }
}
