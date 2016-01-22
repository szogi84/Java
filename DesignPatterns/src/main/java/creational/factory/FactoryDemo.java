package creational.factory;

/**
 * Created by sczerwinski on 2016-01-19.
 */
public class FactoryDemo {
    public static void main(String[] args){
        Website site = new WebsiteFactory().getWebsite(WebsiteType.BLOG);
        System.out.println(site.getPages());
        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(site.getPages());

    }
}
