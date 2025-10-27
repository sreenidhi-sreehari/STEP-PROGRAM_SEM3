class Phone {
    String brand;
    String model;

    // Default constructor
    Phone() {
        System.out.println("Phone default constructor called");
        brand = "Unknown";
        model = "Unknown";
    }

    // Parameterized constructor
    Phone(String brand, String model) {
        System.out.println("Phone parameterized constructor called");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    String operatingSystem;

    // Default constructor
    SmartPhone() {
        super(); // Calls Phone's default constructor
        System.out.println("SmartPhone default constructor called");
        operatingSystem = "UnknownOS";
    }

    // Parameterized constructor
    SmartPhone(String brand, String model, String os) {
        super(brand, model); // Calls Phone's parameterized constructor
        System.out.println("SmartPhone parameterized constructor called");
        operatingSystem = os;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Phone p1:");
        Phone p1 = new Phone();

        System.out.println("\nCreating Phone p2:");
        Phone p2 = new Phone("Nokia", "3310");

        System.out.println("\nCreating SmartPhone s1:");
        SmartPhone s1 = new SmartPhone();

        System.out.println("\nCreating SmartPhone s2:");
        SmartPhone s2 = new SmartPhone("Apple", "iPhone 13", "iOS");
    }
}
