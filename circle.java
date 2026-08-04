// Create a classroom select that creates a method which accepts the radius of the circle and finds the area and circumference. 
// Use the previous class calculator to find the area and circumference of the circle.

import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        final double PI = 3.14;
        double area = calc.mul(PI, calc.mul(radius, radius));
        double circumference = calc.mul(2, calc.mul(PI, radius));

        System.out.println("Area of the circle: " + area);
        System.out.println("Circumference of the circle: " + circumference);
        sc.close();
    }
}