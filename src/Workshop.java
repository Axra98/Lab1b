import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Workshop <T extends Car> implements Load<T> {

    private T car;
    private int max;
    private List<T> store;

    public Workshop (T car, int max) {
        this.car = car;
        this.max = max;
        store = new ArrayList<>();
    }

    public void loadCar(T car) {
        if(store.size() < max) {
            store.add(car);
        }
    }

    public void removeCar(T car){
        if(store.contains(car))
            removeCar(car);
    }
}

