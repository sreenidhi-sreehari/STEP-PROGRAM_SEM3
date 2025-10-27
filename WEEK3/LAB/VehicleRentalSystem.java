class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName;
    private static int rentalDays = 0;

    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }

    public boolean rentVehicle(int days) {
        if (isAvailable) {
            double rent = calculateRent(days);
            isAvailable = false;
            System.out.println("Vehicle " + vehicleId + " rented for " + days + " days. Rent: $" + rent);
            return true;
        } else {
            System.out.println("Vehicle " + vehicleId + " is currently not available.");
            return false;
        }
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned and now available.");
        } else {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        }
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle ID     : " + vehicleId);
        System.out.println("Brand          : " + brand);
        System.out.println("Model          : " + model);
        System.out.println("Rent per Day   : $" + rentPerDay);
        System.out.println("Available      : " + (isAvailable ? "Yes" : "No"));
        System.out.println("--------------------------------------");
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) {
            return 0.0;
        }
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("Company Name       : " + companyName);
        System.out.println("Total Vehicles     : " + totalVehicles);
        System.out.println("Total Revenue      : $" + totalRevenue);
        System.out.println("Average Rent/Day   : $" + getAverageRentPerDay());
        System.out.println("--------------------------------------");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("City Rentals");

        Vehicle v1 = new Vehicle("V001", "Toyota", "Camry", 50);
        Vehicle v2 = new Vehicle("V002", "Honda", "Civic", 45);
        Vehicle v3 = new Vehicle("V003", "Ford", "Mustang", 80);

        System.out.println("Initial Vehicle Details:");
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        System.out.println("Renting Vehicles:");
        v1.rentVehicle(3); // Rented 3 days
        v2.rentVehicle(2); // Rented 2 days

        System.out.println("\nVehicle Details After Renting:");
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        System.out.println("Returning Vehicle V1:");
        v1.returnVehicle();

        System.out.println("\nVehicle Details After Return:");
        v1.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}
