package creational.factory;

/**
 * Created by sczerwinski on 2016-01-19.
 */
public class Shop extends Website {

    @Override
    protected void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
    }
}
