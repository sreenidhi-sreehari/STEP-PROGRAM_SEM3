import java.util.*;

public class CSVAnalyzer {

    public static String[][] parseCSV(String data) {
        List<String[]> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();
        StringBuilder field = new StringBuilder();

        boolean inQuotes = false;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (c == '"') {
                // toggle quotes
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                row.add(field.toString().trim());
                field.setLength(0);
            } else if (c == '\n' && !inQuotes) {
                row.add(field.toString().trim());
                rows.add(row.toArray(new String[0]));
                row.clear();
                field.setLength(0);
            } else {
                field.append(c);
            }
        }

        // Add last field/row
        if (field.length() > 0 || !row.isEmpty()) {
            row.add(field.toString().trim());
            rows.add(row.toArray(new String[0]));
        }

        return rows.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter CSV data (empty line to finish):");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            sb.append(line).append("\n");
        }

        String[][] data = parseCSV(sb.toString());

        // Display parsed data
        for (String[] r : data) {
            for (String f : r) {
                System.out.print(f + " | ");
            }
            System.out.println();
        }

        sc.close();
    }
}
