package structural.flyweight;

/**
 * Created by sczerwinski on 2016-01-28.
 */
public class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
