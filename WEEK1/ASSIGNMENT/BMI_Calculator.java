import java.util.Scanner;

public class BMI_Calculator {

    // Method to calculate BMI and Status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method that computes BMI and stores in 2D String array
    public static String[][] processBMI(double[][] hwArray) {
        String[][] result = new String[hwArray.length][4];

        for (int i = 0; i < hwArray.length; i++) {
            double weight = hwArray[i][0];
            double height = hwArray[i][1];
            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];  // BMI
            result[i][3] = bmiData[1];  // Status
        }

        return result;
    }

    // Method to display results in tabular format
    public static void display(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwArray = new double[10][2];

        // Taking user input
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            hwArray[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            hwArray[i][1] = sc.nextDouble();
        }

        // Process BMI
        String[][] result = processBMI(hwArray);

        // Display results
        display(result);

        sc.close();
    }
}
