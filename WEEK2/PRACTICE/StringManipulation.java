import java.util.*;

public class StringManipulation {

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            w = w.replaceAll("\\p{Punct}", "");
            if (!w.isEmpty()) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }
        System.out.println("Word Frequency: " + freq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting: ");
        String input = sc.nextLine();

        System.out.println("Trimmed: " + input.trim());
        System.out.println("Spaces -> Underscores: " + input.replace(" ", "_"));
        System.out.println("No Digits: " + input.replaceAll("\\d", ""));
        String[] words = input.split(" ");
        System.out.println("Words Array: " + Arrays.toString(words));
        System.out.println("Joined with | : " + String.join(" | ", words));

        System.out.println("No punctuation: " + removePunctuation(input));
        System.out.println("Capitalized: " + capitalizeWords(input));
        System.out.println("Reversed words: " + reverseWordOrder(input));
        countWordFrequency(input);

        sc.close();
    }
}
