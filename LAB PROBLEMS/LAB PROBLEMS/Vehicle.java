
// LAB PROBLEM 3: Abstract Vehicle and Maintainable Interface
abstract class AbstractVehicle {
    protected int speed;
    protected String fuelType;

    public AbstractVehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

interface Maintainable {
    void serviceInfo();
}

class Car extends AbstractVehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started. Speed: " + speed + " km/h, Fuel: " + fuelType);
    }

    @Override
    public void serviceInfo() {
        System.out.println(model + " requires servicing every 6 months.");
    }
}

public class Vehicle {
    public static void main(String[] args) {
        Car car = new Car(120, "Petrol", "Honda City");
        car.startEngine();
        car.serviceInfo();
    }
}
