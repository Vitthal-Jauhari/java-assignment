// Q25: Demonstration of Math.random(), Math.abs(), and Math.pow() from java.lang package.

public class Q25_MathDemo {
    public static void main(String[] args) {
        // 1. Math.abs()
        int negativeInt = -42;
        double negativeDouble = -99.75;
        System.out.println("--- Math.abs() ---");
        System.out.println("Math.abs(" + negativeInt + ") = " + Math.abs(negativeInt));
        System.out.println("Math.abs(" + negativeDouble + ") = " + Math.abs(negativeDouble));

        // 2. Math.pow()
        double base = 2.0;
        double exponent = 8.0;
        System.out.println("\n--- Math.pow() ---");
        System.out.println(base + " raised to the power of " + exponent + " = " + Math.pow(base, exponent));
        System.out.println("5 raised to power 3 = " + Math.pow(5, 3));

        // 3. Math.random()
        System.out.println("\n--- Math.random() ---");
        System.out.println("Random double [0.0, 1.0): " + Math.random());
        // Generate random integer between 1 and 100
        int randomInt = (int) (Math.random() * 100) + 1;
        System.out.println("Random integer between 1 and 100: " + randomInt);
    }
}
