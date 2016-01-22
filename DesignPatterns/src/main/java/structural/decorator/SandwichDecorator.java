package structural.decorator;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customSandwich;

    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    public String make(){
        return customSandwich.make();
    }
}
