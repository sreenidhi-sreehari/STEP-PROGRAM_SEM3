import java.util.Scanner;

public class CalendarDisplay {
    static String[] months = {"January","February","March","April","May","June","July",
            "August","September","October","November","December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getDays(int month, int year) {
        if (month == 2 && isLeap(year)) return 29;
        return days[month - 1];
    }

    public static int startDay(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    public static void printCalendar(int month, int year) {
        System.out.println("   " + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int start = startDay(1, month, year);
        for (int i = 0; i < start; i++) System.out.print("    ");
        int daysInMonth = getDays(month, year);
        for (int d = 1; d <= daysInMonth; d++) {
            System.out.printf("%3d ", d);
            if (((d + start) % 7 == 0) || d == daysInMonth) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month (1-12):");
        int m = sc.nextInt();
        System.out.println("Enter year:");
        int y = sc.nextInt();
        printCalendar(m, y);
        sc.close();
    }
}
