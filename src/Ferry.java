import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Ferry extends Vehicle implements Load{

    private int max;
    public List<Car> store;
    private double enginePower, currentSpeed, x, y, length; // Engine power of the car The current speed of the car, riktningarna i planet för move.
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vehicle.Direction direction = Vehicle.Direction.UP;
    private Point.Double position; //default x=0, y=0
    private Vehicle parent = new Vehicle();


    public Ferry(int max) {
        this.enginePower = 500;
        this.color = Color.CYAN;
        this.modelName = "Färja 1";
        this.position = new Point2D.Double(0,0);
        this.length = 80;
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

    protected void startEngine() {
        parent.startEngine();
    }

    protected void stopEngine() {
        parent.stopEngine();
    }

    public void gas(double amount) {
        parent.gas(amount);
    }

    public void brake (double amount){
        parent.brake(amount);
    }

    protected enum Direction {
        RIGHT,
        LEFT,
        UP,
        DOWN,
    }

    public void move () {
        parent.move();
    }

    public void turnLeft () {
        parent.turnLeft();
    }

    public void turnRight () {
        parent.turnLeft();
    }

    protected Point2D.Double getPos () {
        return parent.getPos();
    }
    protected Vehicle.Direction getDirection () {
        return parent.getDirection();
    }

    protected void setDirection (Vehicle.Direction direction){
        parent.setDirection(direction);
    }

    protected void setPosition (Point2D.Double position){
        parent.setPosition(position);
    }

    protected double getLength () {
        return parent.getLength();
    }

}
