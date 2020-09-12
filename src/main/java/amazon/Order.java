package amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author : alexchen
 * @created : 9/11/20, Friday
 **/
@ToString
public class Order {

    @Getter
    private int orderId;

    @Getter
    private List<ProductItem> productItems;

    @Getter
    private double amount;

    @Getter
    private Account account;

    @Getter
    @Setter
    private OrderStatus orderStatus;

    @Getter
    private Date orderTime;

    @Getter
    private Date lastUpdateTime;

    public Order(int orderId, List<ProductItem> productItems, double amount, Account account) {
        this.orderId = orderId;
        this.productItems = productItems;
        this.amount = amount;
        this.account = account;
        orderStatus = OrderStatus.CREATED;
        orderTime = new Date();
        lastUpdateTime = new Date();
    }
}
