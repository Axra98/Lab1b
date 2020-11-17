import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car{

    private int nrDoors; // Number of doors on the car
    private double enginePower, currentSpeed, x,y; // Engine power of the car The current speed of the car, riktningarna i planet för move.
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction = Direction.UP;
    private Point.Double position; //default x=0, y=0

    /**
     *
     * @param nrDoors anger antalet dörrar
     * @param enginePower anger motoreffekt
     * @param color anger färgen
     * @param modelName anger modelnamn
     * @param position anger bilens startposition
     */
    protected Car (int nrDoors, double enginePower, Color color, String modelName, Point.Double position){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
        stopEngine();
    }

    /**
     * Returnerar antalet dörrar.
     * @return
     */
    protected int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returnerar motoreffekten
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /** Eftersom incrementspeed och decrementspeed ger att man inte kan överstiga
     * enginepower respektive understiga 0
     * Returnerar currentSpeed
     */
    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returnerar färgen på en bil
     */
    protected Color getColor(){
        return color;
    }

    /**
     * Används för att sätta färgen på en bil
     * @param clr är av typen Color som bestämmer objektets färg
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Startar motorn
     */
    protected void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stänger av motorn
     */
    protected void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * En speedFactor som anvädns i incrementSpeed och decrementSpeed
     */
    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0.0);
    }

    /**
     * @param amount är av typen Double som avgör hur mycket currentSpeed ökar
     * Metoden ökar hastigheten på bilen med amount
     */
    public void gas(double amount){
        if(amount>=0.0 && amount <= 1.0)
            incrementSpeed(amount);
    }

    /**
     *Minskar hastigheten på bilen med amount
     * @param amount är av typen Double som avgör hur mycket currentSpeed minskar
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount>=0.0 && amount <= 1.0)
            decrementSpeed(amount);
    }

    /** Skapar en enum med riktningar. Dessa går inte att ändra och är lite som
     * "final variables"
     */
    protected enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN,
    }

     /**Tanken är att man ska ändra x/y koordninaterna efter riktning och hastighet
     eftersom vi gör om Point till en double använder vi setLocation istället för move för
     att byta position.
     */
    public void move() {
        switch (direction){
            case UP: position.setLocation(x, y += currentSpeed); break;
            case RIGHT: position.setLocation(x += currentSpeed, y); break;
            case DOWN: position.setLocation(x, y -= currentSpeed); break;
            case LEFT: position.setLocation(x -= currentSpeed, y); break;
        }
    }

    /** Här ändras riktningen mha switch statement. Så vid turnLeft så ändras riktningen ett steg till vänster
     * så turnLeft: UP->LEFT, LEFT->DOWN
     */
    public void turnLeft() {
        switch (direction){
            case UP: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.DOWN; break;
            case DOWN: direction = Direction.RIGHT; break;
            case RIGHT: direction = Direction.UP; break;
        }
    }

    /** Samma princip som i turnLeft fast åt motsatt håll.
     *
     */
   public void turnRight() {
        switch (direction){
            case UP: direction = Direction.RIGHT; break;
            case RIGHT: direction = Direction.DOWN; break;
            case DOWN: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.UP; break;
        }
    }

    /**
     *Returnerar en bils position
     */
    protected Point2D getPos(){
       return position;
    }

    /**
     * Returnerar bilens riktning
     */
    protected Direction getDirection() {
        return direction;
    }

    /**
     * En setter för Direction
     * @param direction anger riktningen för bilen
     */
    protected void setDirection(Direction direction) {
        this.direction = direction;
    }

    protected void setPosition(Point.Double position) {
        this.position = position;
    }
}
