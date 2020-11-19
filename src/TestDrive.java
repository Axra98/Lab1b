public class TestDrive {
    public static void main(String[] args){
        CarTransport myTruck = new CarTransport(6);
        Volvo240 volvo = new Volvo240();
        myTruck.startEngine();
        myTruck.stopEngine();
        myTruck.rampDown();
        myTruck.loadCar(volvo);

    }
}
