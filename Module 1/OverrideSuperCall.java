// Create a program to show method overriding and the use of super to call the parent class method

public class OverrideSuperCall {

    static class Shape {
        void draw() {
            System.out.println("Drawing a shape");
        }
    }

    static class Rectangle extends Shape {
        @Override
        void draw() {
            super.draw(); // calls parent class method first
            System.out.println("Drawing a rectangle");
        }
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.draw();
    }
}
