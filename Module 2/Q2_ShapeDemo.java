import java.util.Scanner;
import shapes.Shape;
import shapes.Circle;
import shapes.Rectangle;

public class Q2_ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();
        Shape c = new Circle(radius);

        System.out.print("Enter length of the rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        double width = sc.nextDouble();
        Shape r = new Rectangle(length, width);

        System.out.println("Circle area: " + c.area() + ", perimeter: " + c.perimeter());
        System.out.println("Rectangle area: " + r.area() + ", perimeter: " + r.perimeter());

        sc.close();
    }
}
