abstract class Vehicle {
    abstract void start();
    void stop() {
        System.out.println("Vehicle stopped.");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    @Override
    void start() {
        System.out.println("Car started.");
    }
    @Override
    public void refuel() {
        System.out.println("Car refueled.");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.refuel();
        c.stop();
    }
}
