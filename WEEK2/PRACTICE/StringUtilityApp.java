import java.util.*;

public class StringUtilityApp {

    private static StringBuilder output = new StringBuilder();

    public static void performTextAnalysis(String text) {
        output.append("Length: ").append(text.length()).append("\n");
        String[] words = text.split("\\s+");
        output.append("Word count: ").append(words.length).append("\n");

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        output.append("Character Frequency: ").append(freq).append("\n");
    }

    public static String performTransformations(String text, String[] ops) {
        StringBuilder sb = new StringBuilder(text);
        for (String op : ops) {
            if (op.equalsIgnoreCase("trim")) text = text.trim();
            if (op.equalsIgnoreCase("upper")) text = text.toUpperCase();
            if (op.equalsIgnoreCase("lower")) text = text.toLowerCase();
        }
        return text;
    }

    public static void performASCIIOperations(String text) {
        for (char c : text.toCharArray()) {
            output.append(c).append(" -> ").append((int)c).append("\n");
        }
    }

    public static void performPerformanceTest(int iterations) {
        long start = System.nanoTime();
        StringPerformanceComparison.concatenateWithString(iterations);
        long end = System.nanoTime();
        output.append("String concat: ").append(end - start).append(" ns\n");
    }

    public static void displayResults() {
        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APP ===");
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        performTextAnalysis(text);
        performASCIIOperations(text);
        performPerformanceTest(1000);
        displayResults();

        sc.close();
    }
}
