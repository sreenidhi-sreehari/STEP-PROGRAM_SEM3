import java.util.*;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                encrypted.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                encrypted.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("Decryption valid: " + text.equals(decrypted));
    }
}
