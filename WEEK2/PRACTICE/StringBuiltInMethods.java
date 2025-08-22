public class StringBuiltInMethods {

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        System.out.print("Occurrences of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";

        System.out.println("Original length (with spaces): " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("Trimmed length: " + trimmed.length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        System.out.println("Substring 'Programming': " + sampleText.substring(7, 18));
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("Contains 'Java'? " + sampleText.contains("Java"));
        System.out.println("Starts with 'Java' (after trim)? " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());

        System.out.println("Vowel count: " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }
}
