import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name (First Last): ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = (nameParts.length > 1) ? nameParts[1] : "";

        int charCount = sentence.replace(" ", "").length();
        String langUpper = language.toUpperCase();

        System.out.println("\n=== SUMMARY ===");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + langUpper);
        System.out.println("Sentence (char count without spaces): " + charCount);

        scanner.close();
    }
}
