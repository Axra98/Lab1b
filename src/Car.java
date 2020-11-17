import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car extends Vehicle implements Movable{

    /**
     *
     * @param nrDoors anger antalet dörrar
     * @param enginePower anger motoreffekt
     * @param color anger färgen
     * @param modelName anger modelnamn
     * @param position anger bilens startposition
     */
    protected Car (int nrDoors, double enginePower, Color color, String modelName, Point.Double position){
        super(nrDoors, enginePower, color, modelName, position);
        stopEngine();
    }

}
