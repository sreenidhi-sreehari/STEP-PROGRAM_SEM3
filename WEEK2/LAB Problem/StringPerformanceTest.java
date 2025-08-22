//3

import java.util.*;

public class StringPerformanceTest {

    public static long stringConcatTest(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s += "abc";
        }
        long end = System.currentTimeMillis();
        System.out.println("String length: " + s.length());
        return end - start;
    }

    public static long stringBuilderTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder length: " + sb.length());
        return end - start;
    }

    public static long stringBufferTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        long t1 = stringConcatTest(n);
        long t2 = stringBuilderTest(n);
        long t3 = stringBufferTest(n);

        System.out.println("\nPerformance Comparison:");
        System.out.println("String (+)       : " + t1 + " ms");
        System.out.println("StringBuilder    : " + t2 + " ms");
        System.out.println("StringBuffer     : " + t3 + " ms");
    }
}
