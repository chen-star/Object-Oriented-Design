package amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
public class Category {

    @Getter
    @Setter
    private final int categoryId;

    @Getter
    private String categoryName;

    @Getter
    private List<Product> products;


    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
