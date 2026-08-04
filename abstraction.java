// WAP to demonstrate abstraction in Java using interfaces

interface Shape {
    void area();
}

class Square implements Shape {
    double side = 4.0;

    @Override
    public void area() {
        System.out.println("Area of square: " + (side * side));
    }
}

class Triangle implements Shape {
    double base = 5.0, height = 6.0;

    @Override
    public void area() {
        System.out.println("Area of triangle: " + (0.5 * base * height));
    }
}

public class abstraction {
    public static void main(String[] args) {
        Shape s1 = new Square();
        Shape s2 = new Triangle();

        s1.area();
        s2.area();
    }
}
