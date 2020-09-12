package amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
@ToString
public class ProductItem {

    @Getter
    private final int productItemId;

    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private double price;

    public ProductItem(int productItemId, String productName, double price) {
        this.productItemId = productItemId;
        this.productName = productName;
        this.price = price;
    }
}
