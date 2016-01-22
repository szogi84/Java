package creational.factory;

/**
 * Created by sczerwinski on 2016-01-19.
 */
public class WebsiteFactory {

    public static Website getWebsite(WebsiteType siteType ){
        if (siteType.equals(WebsiteType.BLOG)) {
            return new Blog();
        } else if (siteType.equals(WebsiteType.SHOP)) {
            return new Shop();
        } else {
            return null;
        }
    }
}
