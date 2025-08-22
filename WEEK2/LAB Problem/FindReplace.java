//1
import java.util.*;

public class FindReplace {
    public static List<Integer> findOccurrences(String text, String find) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(find);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + 1);
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() &&
                text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String manual, String text, String find, String replace) {
        String builtIn = text.replace(find, replace);
        return manual.equals(builtIn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter replacement: ");
        String replace = sc.nextLine();

        List<Integer> positions = findOccurrences(text, find);
        String manual = manualReplace(text, find, replace);
        boolean isSame = compareWithBuiltIn(manual, text, find, replace);

        System.out.println("Manual Replace: " + manual);
        System.out.println("Built-in Replace: " + text.replace(find, replace));
        System.out.println("Comparison result: " + isSame);
        System.out.println("Occurrences at positions: " + positions);
    }
}
