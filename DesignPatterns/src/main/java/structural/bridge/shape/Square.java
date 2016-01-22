package structural.bridge.shape;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }
}
