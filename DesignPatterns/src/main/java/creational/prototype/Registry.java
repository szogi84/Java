package creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sczerwinski on 2016-01-18.
 */
public class Registry {

    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry(){
        loadItems();
    }

    //prototype
    public Item createItem (String type) {
        Item item = null;

        try{
            item = (Item)(items.get(type)).clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);

        Book book = new Book();
        book.setTitle("Basic book");
        book.setNumberOfPages(255);
        book.setPrice(24.99);
        items.put("Book", book);
    }

}
