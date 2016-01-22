package structural.decorator;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class MeatDecorator extends SandwichDecorator{

    public MeatDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make(){
        return customSandwich.make() + addMeat();
    }

    private String addMeat() {
        return " + turkey";
    }

}
