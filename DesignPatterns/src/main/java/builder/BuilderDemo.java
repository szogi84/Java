package builder;

/**
 * Created by sczerwinski on 2016-01-18.
 */
public class BuilderDemo {

    public static void main(String[] args){
        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat").condiments("Dupa");
        LunchOrder lunchOrder = builder.build();


        System.out.println(lunchOrder.getBread());
    }
}
