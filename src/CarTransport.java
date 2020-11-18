import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends SuperTruck implements Load{

    private boolean up = true;
    private List<Car> cars = new ArrayList<>();

    /**
     * Construktor, apply startvalues to an object of Truck
     */
    public CarTransport() {
        super(2, 300, Color.BLUE, "Truck", new Point2D.Double(0,0));
        stopEngine();
    }

    /**
     *  Lifts the ramp up
     */
    public void rampUp() {
        up = true;
    }

    /**
     *  If the truck is still put down the ramp
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

        if(up == false && cars.size()<=6) { // satt en in en maxgräns på 6
            if(Math.abs(car.getPos().getX() - getPos().getX()) <4 &&  Math.abs(car.getPos().getY() - getPos().getY()) <4) {
                cars.add(car);
                car.setPosition(getPos());
            }
        } else {
            System.out.println("Could not load");
        }
    }


    /**
     * Removes a Car from the Truck
     * @param car which car you want to remove
     */
    public void removeCar(Car car) {
        int last = cars.lastIndexOf(car);
        if(up == false && cars.contains(car) && cars.indexOf(car) == last) {
            cars.remove(car);
            car.setPosition(new Point2D.Double(getPos().getX() + 4, getPos().getY()));
        }
    }

}