import java.util.Scanner;

public class Q7_TryCatchFinally {

    static void divideTryCatch(int a, int b) {
        try {
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static void divideTryCatchFinally(int a, int b) {
        try {
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        System.out.println("--- try-catch ---");
        divideTryCatch(a, b);

        System.out.println("--- try-catch-finally ---");
        divideTryCatchFinally(a, b);

        sc.close();
    }
}
