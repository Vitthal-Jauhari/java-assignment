// Implement a program to demonstrate the use of a copy constructor in Java

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    void display() {
        System.out.println("Point(" + x + ", " + y + ")");
    }
}

public class copy_constructor {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(p1);

        p1.display();
        p2.display();

        p2.x = 10;
        System.out.println("After modifying p2:");
        p1.display();
        p2.display();
    }
}
