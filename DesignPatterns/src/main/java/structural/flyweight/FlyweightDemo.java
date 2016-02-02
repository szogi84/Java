package structural.flyweight;

/**
 * Created by sczerwinski on 2016-01-28.
 */
public class FlyweightDemo {

    public static void main(String[] args) {

        InventorySystem ims = new InventorySystem();

        ims.takeOrder("Roomba", 221);
        ims.takeOrder("Samsung TV", 432);
        ims.takeOrder("Roomba", 321);

        ims.process();

        System.out.println(ims.report());

    }
}
