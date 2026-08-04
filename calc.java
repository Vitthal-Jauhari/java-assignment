// Create a classmate calculator 
// Add a method name add 
// The method should return the sum of the numbers in the main method. 
// Extend the above for Subtraction Multiplication and Division methods as well
// Calculator calc = new Calculator();

import java.util.Scanner;

class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }
}
public class calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Addition: " + calc.add(num1, num2));
        System.out.println("Subtraction: " + calc.sub(num1, num2));
        System.out.println("Multiplication: " + calc.mul(num1, num2));
        System.out.println("Division: " + calc.div(num1, num2));
        sc.close();
    }
}