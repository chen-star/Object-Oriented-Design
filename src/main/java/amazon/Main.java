package amazon;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
public class Main {

    public static void main(String[] args) {
        // init
        Amazon amazon = new Amazon();

        Category category1 = new Category(1, "Shoes");
        Category category2 = new Category(2, "Laptop");
        Category category3 = new Category(3, "Headphone");

        amazon.getCategoryMap().put(1, category1);
        amazon.getCategoryMap().put(2, category2);
        amazon.getCategoryMap().put(3, category3);

        Product product1 = new Product(1, "Nike");
        Product product2 = new Product(2, "Mac");
        Product product3 = new Product(3, "IBM");
        Product product4 = new Product(4, "DELL");
        Product product5 = new Product(5, "Bose");
        Product product6 = new Product(6, "B&O");

        ProductItem item1 = new ProductItem(1, "Mac 13", 2000);
        ProductItem item2 = new ProductItem(2, "Mac 16", 2900);
        ProductItem item3 = new ProductItem(3, "B&O", 500);
        product2.addProductItem(item1);
        product2.addProductItem(item2);
        product6.addProductItem(item3);

        category1.addProduct(product1);
        category2.addProduct(product2);
        category2.addProduct(product3);
        category2.addProduct(product4);
        category3.addProduct(product5);
        category3.addProduct(product6);

        // search
        System.out.println(amazon.searchByCategory(2));

        // add an item
        Account account1 = new Account(1, "Alex");
        Account account2 = new Account(2, "Jeremy");
        amazon.addShoppingCart(account1, item1);
        amazon.addShoppingCart(account1, item3);
        amazon.addShoppingCart(account2, item2);

        // checkout
        System.out.println(amazon.checkout(account1));
    }
}
