import java.util.Scanner;

public class CharFrequencyNested {
    public static String[] frequency(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[j] != '0') {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        int valid = 0;
        for (int f : freq) if (f > 0) valid++;
        String[] result = new String[valid];
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0 && chars[i] != '0') {
                result[idx++] = chars[i] + " -> " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = sc.nextLine();
        for (String row : frequency(str)) System.out.println(row);
        sc.close();
    }
}
