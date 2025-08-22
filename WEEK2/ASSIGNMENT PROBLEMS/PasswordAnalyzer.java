import java.util.*;

public class PasswordAnalyzer {

    public static int[] analyze(String password) {
        int up = 0, low = 0, dig = 0, spec = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) up++;
            else if (Character.isLowerCase(c)) low++;
            else if (Character.isDigit(c)) dig++;
            else spec++;
        }
        return new int[]{up, low, dig, spec};
    }

    public static int calculateScore(String pwd, int[] counts) {
        int score = 0;

        // Base length score
        if (pwd.length() >= 8) score += 10;
        if (pwd.length() > 8) score += (pwd.length() - 8) * 2;

        // Bonus for variety (at least 1 of each type)
        for (int c : counts) {
            if (c > 0) score += 10;
        }

        // Common weak patterns penalty
        String lowerPwd = pwd.toLowerCase();
        if (lowerPwd.contains("123") || lowerPwd.contains("abc") || lowerPwd.contains("qwerty")) {
            score -= 10;
        }

        // Clamp to non-negative
        if (score < 0) score = 0;

        return score;
    }

    public static String getStrength(int score) {
        if (score <= 20) return "Weak";
        if (score <= 50) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s %-10s\n",
                "Password", "Len", "Upper", "Lower", "Digit", "Spec", "Score", "Strength");

        for (int i = 0; i < n; i++) {
            String pwd = sc.nextLine();
            int[] counts = analyze(pwd);
            int score = calculateScore(pwd, counts);
            String strength = getStrength(score);

            System.out.printf("%-15s %-8d %-8d %-8d %-8d %-8d %-8d %-10s\n",
                    pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }

        sc.close();
    }
}
