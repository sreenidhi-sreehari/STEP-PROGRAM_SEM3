

abstract class AbstractDevice {
    protected String brand;
    protected String model;

    public AbstractDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void powerOn();
}

interface Connectable {
    void connect();
}

class Smartphone extends AbstractDevice implements Connectable {
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void powerOn() {
        System.out.println(brand + " " + model + " is powering on...");
    }

    @Override
    public void connect() {
        System.out.println(brand + " " + model + " is connecting to WiFi...");
    }
}

public class Device {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", "Galaxy S23");
        phone.powerOn();
        phone.connect();
    }
}
