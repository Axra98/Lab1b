import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SuperTruck extends Vehicle implements Movable{

    protected SuperTruck (int nrDoors, double enginePower, Color color, String modelName, Point.Double position, Double length){
        super(nrDoors, enginePower, color, modelName, position, length);
        stopEngine();
    }

    /**
     * @return speedFactor, depending on enginePower and trimFactor
     */
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}