import java.util.*;

public class TextCaseConverter {

    public static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }

    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                result.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    result.append(toUpperCase(c));
                    newWord = false;
                } else {
                    result.append(toLowerCase(c));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            upper.append(toUpperCase(text.charAt(i)));
            lower.append(toLowerCase(text.charAt(i)));
        }

        String title = toTitleCase(text);

        System.out.println("Original: " + text);
        System.out.println("Manual Uppercase: " + upper);
        System.out.println("Manual Lowercase: " + lower);
        System.out.println("Manual Titlecase: " + title);
        System.out.println("Built-in Uppercase: " + text.toUpperCase());
        System.out.println("Built-in Lowercase: " + text.toLowerCase());
    }
}
