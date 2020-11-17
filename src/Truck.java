import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Truck extends Car{

    private final static double trimFactor = 1.5;
    private boolean up = true;
    private List<Car> cars = new ArrayList<>();

    /**
     * Construktor, apply startvalues to an object of Truck
     */
    public Truck() {
        super(2, 300, Color.BLUE, "Truck", new Point2D.Double(0,0));
        stopEngine();
    }

    /**
     *  Checks if the ramp is up
     */

    public void rampUp() {
        up = true;
    }

    /**
     *  Checks if the ramp is down
     */
    public void rampDown() {
        if(getCurrentSpeed()==0)
            up = false;
    }

    /**
     * Changes the currentSpeed of the Truck
     * @param amount the amount you gas with
     */
    public void gas(Double amount) {
        if(up)
            gas(amount);
    }

    /**
     * Loads a specific Car to the Truck
     * @param car which car you want to load
     */
    public void loadCar(Car car) {
        if(up == false && car.getPos().equals(getPos()) && cars.size()<=6) { // satten in en maxgräns på 6
            cars.add(car);
        }
    }

    /**
     * Removes a Car from the Truck
     * @param car which car you want to remove
     */
    public void removeCar(Car car) {
        int last = cars.lastIndexOf(car);
        if(up == false && cars.contains(car) && cars.indexOf(car) == last)
            cars.remove(car);
    }
    /**
     * @return speedFactor, depending on enginePower and trimFactor
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}