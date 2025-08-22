//2

import java.util.*;

public class TextFormatter {

    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (start < i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        return words;
    }

    public static String justifyLine(List<String> words, int width) {
        if (words.size() == 1) return words.get(0);
        int totalChars = 0;
        for (String w : words) totalChars += w.length();
        int spaces = width - totalChars;
        int gap = spaces / (words.size() - 1);
        int extra = spaces % (words.size() - 1);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < words.size() - 1) {
                for (int j = 0; j < gap + (i < extra ? 1 : 0); j++) {
                    line.append(' ');
                }
            }
        }
        return line.toString();
    }

    public static void formatText(String text, int width) {
        List<String> words = splitWords(text);
        List<String> lineWords = new ArrayList<>();
        int lineLen = 0;

        for (String word : words) {
            if (lineLen + word.length() + lineWords.size() > width) {
                System.out.println(justifyLine(lineWords, width));
                lineWords.clear();
                lineLen = 0;
            }
            lineWords.add(word);
            lineLen += word.length();
        }
        if (!lineWords.isEmpty()) {
            System.out.println(String.join(" ", lineWords));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        formatText(text, width);
    }
}
