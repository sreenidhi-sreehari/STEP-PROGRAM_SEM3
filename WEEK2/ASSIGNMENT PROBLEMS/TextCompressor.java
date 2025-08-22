import java.util.*;

public class TextCompressor {

    public static char[] uniqueChars(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (sb.indexOf("" + c) == -1) sb.append(c);
        }
        char[] arr = new char[sb.length()];
        sb.getChars(0, sb.length(), arr, 0);
        return arr;
    }

    public static int[] frequencies(String text, char[] chars) {
        int[] freq = new int[chars.length];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) freq[j]++;
            }
        }
        return freq;
    }

    public static String[] codes(char[] chars, int[] freq) {
        String[] codes = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            codes[i] = Integer.toString(i, 36); // simple unique codes
        }
        return codes;
    }

    public static String compress(String text, char[] chars, String[] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) {
                    sb.append(codes[j]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String decompress(String comp, char[] chars, String[] codes) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < comp.length()) {
            boolean matched = false;
            for (int j = 0; j < codes.length; j++) {
                if (comp.startsWith(codes[j], idx)) {
                    sb.append(chars[j]);
                    idx += codes[j].length();
                    matched = true;
                    break;
                }
            }
            if (!matched) break; // avoid infinite loop
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] chars = uniqueChars(text);
        int[] freq = frequencies(text, chars);
        String[] codes = codes(chars, freq);

        String comp = compress(text, chars, codes);
        String decomp = decompress(comp, chars, codes);

        System.out.println("Original: " + text);
        System.out.println("Compressed: " + comp);
        System.out.println("Decompressed: " + decomp);

        sc.close();
    }
}
