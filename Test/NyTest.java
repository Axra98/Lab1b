import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NyTest {

    public Volvo240 volvo = new Volvo240();
    public SuperTruck scania = new Scania();
    public CarTransport cartran = new CarTransport(4);
    public Workshop work = new Workshop(volvo, 6);
    public Ferry ferry = new Ferry(100);
    public Saab95 saab = new Saab95();

    @Test
    public void testGetLength() {
        assertTrue(cartran.getLength() == 10.0);
    }//Fel

    @Test
    public void testRampUp() {
        cartran.rampUp();
        assertTrue(cartran.getUp());
    }

    @Test
    public void testRampDown() {
        cartran.rampDown();
        assertFalse(cartran.getUp());
    }

    @Test
    public void testLoadCarTransport() {
        Car car = new Volvo240();
        cartran.rampDown();
        cartran.loadCar(car);
        assertTrue(cartran.cars.contains(car));
    } //fel

    @Test
    public void testRemoveCarTransport() {
        cartran.removeCar(volvo);
        assertFalse(cartran.cars.contains(volvo));
    }//fel

    @Test
    public void testLoadCarFerry() {
        ferry.loadCar(volvo);
        assertTrue(ferry.store.contains(volvo));
    }

    @Test
    public void testRemoveCarFerry() {
        ferry.removeCar(volvo);
        assertFalse(ferry.store.contains(volvo));
    }

    @Test
    public void testStart() {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.1);

    }

    @Test
    public void testSetColor() {
        volvo.setColor(Color.RED);
        assertTrue(volvo.getColor() == Color.RED);
    }

    @Test
    public void testStop() {
        volvo.stopEngine();
        assertTrue(volvo.getCurrentSpeed()==0);
    }

    @Test
    public void testMove() {
        volvo.setPosition(new Point2D.Double(0, 0));
        volvo.setDirection(Vehicle.Direction.UP);
        volvo.startEngine();
        volvo.move();
        assertTrue(volvo.getPos().getX() == 0);
        assertTrue(volvo.getPos().getY() != 0);

        volvo.setDirection(Vehicle.Direction.RIGHT);;
        volvo.move();
        assertTrue(volvo.getPos().getX() != 0);
        assertTrue(volvo.getPos().getY() != 0);

        volvo.setDirection(Vehicle.Direction.DOWN);
        volvo.move();
        assertTrue(volvo.getPos().getX() != 0);
        assertTrue(volvo.getPos().getY() == 0);

        volvo.setDirection(Vehicle.Direction.LEFT);
        volvo.move();
        assertTrue(volvo.getPos().getX() == 0);
        assertTrue(volvo.getPos().getY() == 0);
    }

    @Test
    public void testTurnLeft() {
        volvo.setDirection(Vehicle.Direction.UP);
        volvo.turnLeft();
        assertTrue(volvo.getDirection() == Vehicle.Direction.LEFT);
        volvo.turnLeft();
        assertTrue(volvo.getDirection() == Vehicle.Direction.DOWN);
        volvo.turnLeft();
        assertTrue(volvo.getDirection()== Vehicle.Direction.RIGHT);
        volvo.turnLeft();
        assertTrue(volvo.getDirection()== Vehicle.Direction.UP);

    }

    @Test
    public void testTurnRight() {
        volvo.setDirection(Vehicle.Direction.UP);

        volvo.turnRight();
        assertTrue(volvo.getDirection() == Vehicle.Direction.RIGHT);
        volvo.turnRight();
        assertTrue(volvo.getDirection() == Vehicle.Direction.DOWN);
        volvo.turnRight();
        assertTrue(volvo.getDirection()== Vehicle.Direction.LEFT);
        volvo.turnRight();
        assertTrue(volvo.getDirection()== Vehicle.Direction.UP);
    }

    @Test
    public void testGas() {
        volvo.startEngine();
        double befVolvo = volvo.getCurrentSpeed();
        volvo.gas(1);
        assertTrue(befVolvo < volvo.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        volvo.startEngine();
        double befVolvo = volvo.getCurrentSpeed();
        volvo.brake(1);
        assertTrue(befVolvo > volvo.getCurrentSpeed());
    }

    @Test
    public void testGetNrDoors() {
        assertTrue(volvo.getNrDoors() == 4);
    }

    @Test
    public void testGetEnginePower () {
        assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void testGetCurrentSpeed() {
        // StartEngine funkar så därför använder jag den
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGetColor() {
        assertTrue(volvo.getColor().equals(Color.BLACK));
    }

    @Test
    public void testGetDir() {
        volvo.setDirection(Vehicle.Direction.UP);
        assertTrue(volvo.getDirection().equals(Vehicle.Direction.UP));
    }

    @Test
    public void testGetPos() {
        volvo.setPosition(new Point2D.Double(0,0));
        assertTrue(volvo.getPos().getX() == 0);
        assertTrue(volvo.getPos().getY() == 0);
    }

    @Test
    public void testSpeedFactor() {
        assertTrue(volvo.speedFactor() == 1.2);
    }

    @Test
    public void testTurbo() {
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == 1.25);
    }



}
