package structural.flyweight;

/**
 * Created by sczerwinski on 2016-01-28.
 */
public class Order {

    private final int orderNumber;
    private final Item item;

    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    void processOrder(){
        System.out.println("Ordering " + item + " for order number " + orderNumber);
    }
}
