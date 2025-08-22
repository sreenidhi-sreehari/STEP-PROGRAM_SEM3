public class Example {
    public void print(String s) {
        System.out.println("String: " + s);
    }

    public void print(int i) {
        System.out.println("Integer: " + i);
    }

    public void print(String s, int i) {
        System.out.println("String and int: " + s + ", " + i);
    }

    public static void main(String[] args) {
        Example e = new Example();
        e.print("Hello");
        e.print(5);
        e.print("Age", 30);
    }
}
