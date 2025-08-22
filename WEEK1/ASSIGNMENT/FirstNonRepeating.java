import java.util.Scanner;

public class FirstNonRepeating {
    public static char firstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) freq[text.charAt(i)]++;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) return text.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String input = sc.nextLine();
        char result = firstNonRepeatingChar(input);
        if (result == '\0') System.out.println("No non-repeating character");
        else System.out.println("First non-repeating character: " + result);
        sc.close();
    }
}
