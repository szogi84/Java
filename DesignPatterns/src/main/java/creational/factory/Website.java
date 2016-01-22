package creational.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sczerwinski on 2016-01-19.
 */
public abstract class Website {

    protected List<Page> pages = new ArrayList<Page>();

    public List<Page> getPages() {
        return pages;
    }

    public Website(){
        this.createWebsite();
    }

    protected abstract void createWebsite();
}
