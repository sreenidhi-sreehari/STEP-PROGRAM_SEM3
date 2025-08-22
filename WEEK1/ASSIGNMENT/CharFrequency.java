import java.util.Scanner;

public class CharFrequency {

    // Method to find unique characters in a string
    public static char[] uniqueCharacters(String text) {
        int len = text.length();
        char[] temp = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if already appeared
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Copy only unique chars
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    // Method to find frequencies and return as 2D String array
    public static String[][] findFrequencies(String text) {
        int[] freq = new int[256]; // frequency array for ASCII chars

        // count frequencies
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        // get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // store results in 2D String array
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    // Method to display results
    public static void display(String[][] data) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Process
        String[][] result = findFrequencies(input);

        // Display
        display(result);

        sc.close();
    }
}
