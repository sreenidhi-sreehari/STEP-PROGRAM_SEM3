import java.util.Scanner;

public class PalindromeCheck {
    public static boolean checkIterative(String text) {
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static boolean checkRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return checkRecursive(text, start + 1, end - 1);
    }

    public static boolean checkCharArray(String text) {
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        for (int i = 0; i < arr.length; i++) if (arr[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Iterative: " + checkIterative(str));
        System.out.println("Recursive: " + checkRecursive(str, 0, str.length() - 1));
        System.out.println("CharArray: " + checkCharArray(str));
        sc.close();
    }
}
