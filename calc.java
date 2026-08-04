// Create a classmate calculator 
// Add a method name add 
// The method should return the sum of the numbers in the main method. 
// Extend the above for Subtraction Multiplication and Division methods as well
// Calculator Calc = new Calculator();

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
public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator Calc = new Calculator();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Addition: " + Calc.add(num1, num2));
        System.out.println("Subtraction: " + Calc.sub(num1, num2));
        System.out.println("Multiplication: " + Calc.mul(num1, num2));
        System.out.println("Division: " + Calc.div(num1, num2));
        sc.close();
    }
}