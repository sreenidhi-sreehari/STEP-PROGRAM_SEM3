public class StringPerformanceComparison {

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i + " ";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        long start = System.nanoTime();
        concatenateWithString(5000);
        long end = System.nanoTime();
        System.out.println("String concat time: " + (end - start) + " ns");

        start = System.nanoTime();
        concatenateWithStringBuilder(5000);
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");

        start = System.nanoTime();
        concatenateWithStringBuffer(5000);
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");
    }
}
