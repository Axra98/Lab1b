import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;

import java.util.Deque;


public class CarTransport extends SuperTruck implements Load{

    private boolean up = true;
    private Deque<Car> cars = new ArrayDeque<>();

    /**
     * Construktor, apply startvalues to an object of Truck
     */
    public CarTransport() {
        super(2, 300, Color.BLUE, "Truck", new Point2D.Double(0,0), 10.0);
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

    @Override
    public void move(){
        super.move();
        for(Car e : cars){
            e.setPosition(getPos());
        }
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

        if(up == false && cars.size()<=6) { // satt in en maxgräns på 6
            if(getPos().distance(car.getPos()) < 4 && car.getLength() < 5) {
                cars.add(car);
                car.setPosition(getPos());
            }
        }
        else {
            System.out.println("Could not load");
        }
    }


    public void removeCar(Car car) {
       if(cars.peekLast().equals(car)){
            switch (getDirection()) {
                case UP:
                    car.setPosition(new Point2D.Double(car.getPos().getX(), car.getPos().getY()-2));
                    break;
                case RIGHT:
                    car.setPosition(new Point2D.Double(car.getPos().getX()-2, car.getPos().getY()));
                    break;
                case DOWN:
                    car.setPosition(new Point2D.Double(car.getPos().getX(), car.getPos().getY()+2));
                    break;
                case LEFT:
                    car.setPosition(new Point2D.Double(car.getPos().getX()+2, car.getPos().getY()));
                    break;


            }
        }
       else
           System.out.println("Din idiot den bilen går inte att ta ut!");
    }
}