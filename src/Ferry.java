import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Ferry extends Vehicle implements Load{

    private int max;
    private List<Car> store;

    public Ferry(int max) {
        super(0, 500, Color.WHITE, "Ferry", new Point2D.Double(0,0), 80.0);
        store = new ArrayList<>();
        this.max = max;
    }

    public void loadCar(Car car) {
        if(store.size() < max) {
            store.add(car);
        }
    }

    public void removeCar(Car car) {
        if(store.contains(car) && store.indexOf(car) == 0){
            store.remove(car);
        }
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
