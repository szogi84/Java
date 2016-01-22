package structural.decorator;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make(){
        return customSandwich.make() + addDressing();
    }

    private String addDressing() {
        return " + mustard";
    }
}
