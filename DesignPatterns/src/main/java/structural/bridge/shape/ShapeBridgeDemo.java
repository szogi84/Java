package structural.bridge.shape;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class ShapeBridgeDemo {

    public static void main(String[] args) {
        Color blue = new Blue();

        Shape square = new Square(blue);

        square.applyColor();

        System.out.println("Test");
    }
}
