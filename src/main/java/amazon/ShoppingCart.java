package amazon;


import lombok.Getter;

import java.util.List;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
public class ShoppingCart {

    @Getter
    List<ProductItem> items;

    public ShoppingCart(List<ProductItem> items) {
        this.items = items;
    }

    public void addAnItem(ProductItem item) {
        items.add(item);
    }

    public void removeAnItem(ProductItem item) {
        items.remove(item);
    }
}
