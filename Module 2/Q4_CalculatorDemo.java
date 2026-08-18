import java.util.Scanner;

public class Q4_CalculatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;

        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();

        System.out.println("Add: " + add.compute(a, b));
        System.out.println("Sub: " + sub.compute(a, b));
        System.out.println("Mul: " + mul.compute(a, b));

        sc.close();
    }
}
