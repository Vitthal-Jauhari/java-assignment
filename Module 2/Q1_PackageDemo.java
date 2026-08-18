import java.util.Scanner;
import utilities.MathUtils;

public class Q1_PackageDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathUtils mu = new MathUtils();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Sum: " + mu.add(a, b));

        sc.close();
    }
}
