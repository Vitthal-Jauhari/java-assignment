public class Q4_CalculatorDemo {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;

        System.out.println("Add: " + add.compute(10, 5));
        System.out.println("Sub: " + sub.compute(10, 5));
        System.out.println("Mul: " + mul.compute(10, 5));
    }
}
