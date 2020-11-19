import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SuperTruck implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower, currentSpeed, x,y, length; // Engine power of the car The current speed of the car, riktningarna i planet för move.
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vehicle.Direction direction = Vehicle.Direction.UP;
    private Point.Double position; //default x=0, y=0
    private Vehicle parent = new Vehicle();

   protected SuperTruck (int nrDoors, double enginePower, Color color, String modelName, Point.Double position, Double length){
       this.nrDoors = nrDoors;
       this.enginePower = enginePower;
       this.color = color;
       this.modelName = modelName;
       this.position = position;
       this.length = length;

    }

    protected double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    protected void startEngine(){
        parent.startEngine();
    }

    protected void stopEngine(){
        parent.stopEngine();
    }

    protected void gas(double amount) {
        parent.gas(amount);
    }

    protected void brake(double amount){
        parent.brake(amount);
    }

    public void move() {
        parent.move();
    }

    public void turnLeft() {
        parent.turnLeft();
    }

    public void turnRight() {
        parent.turnLeft();
    }

    protected Point2D.Double getPos(){
        return parent.getPos();
    }

    protected Vehicle.Direction getDirection() {
        return parent.getDirection();
    }

    protected void setDirection(Vehicle.Direction direction) {
        parent.setDirection(direction);
    }

    protected void setPosition(Point2D.Double position) {
        parent.setPosition(position);
    }

    protected double getLength() {
        return parent.getLength();
    }
}