import java.util.*;

public class AdvancedStringAnalyzer {

    public static double calculateSimilarity(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        int distance = dp[str1.length()][str2.length()];
        int maxLen = Math.max(str1.length(), str2.length());
        return (1 - (double)distance/maxLen) * 100;
    }

    public static void performAllComparisons(String s1, String s2) {
        System.out.println("== operator: " + (s1 == s2));
        System.out.println("equals: " + s1.equals(s2));
        System.out.println("equalsIgnoreCase: " + s1.equalsIgnoreCase(s2));
        System.out.println("compareTo: " + s1.compareTo(s2));
        System.out.println("compareToIgnoreCase: " + s1.compareToIgnoreCase(s2));
        System.out.println("Similarity: " + calculateSimilarity(s1, s2) + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        performAllComparisons(s1, s2);

        sc.close();
    }
}
