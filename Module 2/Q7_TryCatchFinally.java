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
        System.out.println("--- try-catch ---");
        divideTryCatch(10, 0);

        System.out.println("--- try-catch-finally ---");
        divideTryCatchFinally(10, 0);
    }
}
