public class StringArrays {
    public static String findLongestName(String[] names) {
        if (names == null || names.length == 0) return null;
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    public static int countNamesStartingWith(String[] names, char letter) {
        if (names == null) return 0;
        int count = 0;
        char target = Character.toLowerCase(letter);
        for (String name : names) {
            if (name.length() > 0 && Character.toLowerCase(name.charAt(0)) == target) {
                count++;
            }
        }
        return count;
    }

    public static String[] formatNames(String[] names) {
        if (names == null) return new String[0];
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                formatted[i] = parts[1] + ", " + parts;
            } else {
                formatted[i] = names[i];
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};
        System.out.println("Longest name: " + findLongestName(students));
        System.out.println("Names starting with A: " + countNamesStartingWith(students, 'A'));
        System.out.println("Formatted names:");
        String[] formatted = formatNames(students);
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
