import java.util.Scanner;

public class UniqueCharacters {

    // Method to find the length of a string without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw exception after last index
                count++;
            }
        } catch (Exception e) {
            // do nothing, count has final length
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int len = getLength(text);
        char[] temp = new char[len]; // temporary array to hold unique chars
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if current char already appeared
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // if unique, add to temp array
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Copy only unique chars to new array
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Find unique characters
        char[] uniqueChars = findUniqueChars(input);

        // Display result
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}
