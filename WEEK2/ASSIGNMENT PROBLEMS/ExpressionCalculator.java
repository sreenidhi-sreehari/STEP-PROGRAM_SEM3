import java.util.*;

public class ExpressionCalculator {

    public static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // Skip spaces
            if (c == ' ') continue;

            // If number, parse full number (multi-digit)
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--;
                values.push(num);
            }
            // Opening bracket
            else if (c == '(') {
                ops.push(c);
            }
            // Closing bracket → solve entire ()
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    values.push(apply(values.pop(), values.pop(), ops.pop()));
                }
                if (!ops.isEmpty()) ops.pop(); // remove '('
            }
            // Operator
            else if ("+-*/".indexOf(c) != -1) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    values.push(apply(values.pop(), values.pop(), ops.pop()));
                }
                ops.push(c);
            }
        }

        // Remaining ops
        while (!ops.isEmpty()) {
            values.push(apply(values.pop(), values.pop(), ops.pop()));
        }

        return values.pop();
    }

    // Apply operation
    public static int apply(int b, int a, char op) { 
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }

    // Operator precedence
    public static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expr = sc.nextLine();

        try {
            System.out.println("Result: " + evaluate(expr));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
