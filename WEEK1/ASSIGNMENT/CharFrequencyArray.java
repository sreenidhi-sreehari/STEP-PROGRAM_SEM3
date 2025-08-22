import java.util.*;

public class CharFrequencyArray {
    public static String[][] frequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) freq[text.charAt(i)]++;
        List<String[]> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result.add(new String[]{String.valueOf(c), String.valueOf(freq[c])});
                freq[c] = 0;
            }
        }
        return result.toArray(new String[result.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = sc.nextLine();
        String[][] out = frequency(str);
        for (String[] row : out) System.out.println(row[0] + " -> " + row);
        sc.close();
    }
}
