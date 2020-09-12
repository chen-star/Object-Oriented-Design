package amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
@ToString
public class Product {

    @Getter
    private final int productId;

    @Getter
    @Setter
    private String productName;

    @Getter
    private List<Category> categoryList;

    @Getter
    private Map<Integer, ProductItem> productItems;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
        categoryList = new ArrayList<>();
        productItems = new HashMap<>();
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public void addProductItem(ProductItem productItem) {
        productItems.put(productItem.getProductItemId(), productItem);
    }

    public ProductItem getAnItem(int productItemId) {
        return productItems.get(productItemId);
    }

    public int getAvailableCount() {
        return productItems.size();
    }
}
