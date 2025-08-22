import java.util.*;

public class ASCIIProcessor {

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char)(ch + 32);
        if (Character.isLowerCase(ch)) return (char)(ch - 32);
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char)((c - base + shift + 26) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char)i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] ascii = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ascii[i] = (int) text.charAt(i);
        }
        return ascii;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) sb.append((char)val);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input = sc.nextLine();

        for (char c : input.toCharArray()) {
            System.out.println(c + " -> " + (int)c + " (" + classifyCharacter(c) + ")");
            if (Character.isLetter(c)) {
                System.out.println("Toggle case: " + toggleCase(c));
            }
        }

        System.out.println("Caesar Cipher (+3): " + caesarCipher(input, 3));
        displayASCIITable(65, 90);
        int[] ascii = stringToASCII(input);
        System.out.println("ASCII Array: " + Arrays.toString(ascii));
        System.out.println("Back to String: " + asciiToString(ascii));

        sc.close();
    }
}
