// Create a program to calculate the factorial of a number using recursion

import java.util.Scanner;

public class FactorialRecursion {
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Factorial of " + n + " is " + factorial(n));
        sc.close();
    }
}
