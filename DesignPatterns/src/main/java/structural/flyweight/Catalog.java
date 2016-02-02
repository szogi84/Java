package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sczerwinski on 2016-01-28.
 */
public class Catalog {
    private Map<String, Item> items = new HashMap<String, Item>();

    //factory method
    public Item lookup(String itemName){
        if (!items.containsKey(itemName))
            items.put(itemName, new Item(itemName));

    return items.get(itemName);
    }

    public int totalItemsMade(){
        return items.size();
    }
}
