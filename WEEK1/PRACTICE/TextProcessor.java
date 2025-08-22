import java.util.*;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder();
        for (String word : input.split(" ")) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) sb.append(word.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replaceAll("\\s+", "").length();
        int sentenceCount = text.split("[.!?]").length;
        String longestWord = "";
        for (String w : words) {
            String clean = w.replaceAll("[^a-zA-Z]", "");
            if (clean.length() > longestWord.length()) longestWord = clean;
        }
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character,Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar + " (" + maxFreq + " times)");
    }

    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.println("Enter a paragraph of text:");
        String input = scanner.nextLine();
        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Input:\n" + cleaned);
        System.out.println("\n--- Text Analysis ---");
        analyzeText(cleaned);
        System.out.println("\n--- Words in Alphabetical Order ---");
        String[] sortedWords = getWordsSorted(cleaned);
        for (String word : sortedWords) {
            System.out.println(word);
        }
        System.out.println("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        System.out.println("Word '" + searchWord + "' found? " + (found ? "Yes" : "No"));
        scanner.close();
    }
}
