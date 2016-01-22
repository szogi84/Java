package structural.bridge.shape;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}
