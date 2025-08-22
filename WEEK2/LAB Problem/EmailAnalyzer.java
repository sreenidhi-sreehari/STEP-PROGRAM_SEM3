import java.util.*;

public class EmailAnalyzer {

    public static boolean validateEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return (at > 0 && at == lastAt && dot > at && dot < email.length() - 1);
    }

    public static void analyzeEmail(String email) {
        if (!validateEmail(email)) {
            System.out.println(email + " -> Invalid");
            return;
        }
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');

        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = email.substring(at + 1, dot);
        String extension = email.substring(dot + 1);

        System.out.println(email + " -> Username: " + username + ", Domain: " + domain +
                ", DomainName: " + domainName + ", Extension: " + extension + " (Valid)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emails (comma separated): ");
        String input = sc.nextLine();
        String[] emails = input.split(",");

        for (String email : emails) {
            analyzeEmail(email.trim());
        }
    }
}
