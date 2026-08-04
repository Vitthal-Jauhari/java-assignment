// Create a program to show method overriding and the use of super to call the parent class method

class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        super.draw(); // calls parent class method first
        System.out.println("Drawing a rectangle");
    }
}

public class override_super_call {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.draw();
    }
}
