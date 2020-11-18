import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {


    private int nrDoors; // Number of doors on the car
    private double enginePower, currentSpeed, x, y, length; // Engine power of the car The current speed of the car, riktningarna i planet för move.
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vehicle.Direction direction = Vehicle.Direction.UP;
    private Point.Double position; //default x=0, y=0

    /**
     * @param nrDoors anger antalet dörrar
     * @param enginePower anger motoreffekt
     * @param color anger färgen
     * @param modelName anger modelnamn
     * @param position anger bilens startposition
     */

    private Vehicle parent;

    protected Car(int nrDoors, double enginePower, Color color, String modelName, Point.Double position, double length) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
        this.length = length;
        stopEngine();
    }

    public double getEnginePower() {
        return parent.getEnginePower();
    }

    public int getNrDoors() {
        return parent.getNrDoors();
    }

    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    protected Color getColor() {
        return parent.getColor();
    }

    protected void setColor(Color clr) {
        parent.setColor(clr);
    }

    protected void startEngine() {
        parent.startEngine();
    }

    protected void stopEngine() {
        parent.stopEngine();
    }

    protected abstract double speedFactor();


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
