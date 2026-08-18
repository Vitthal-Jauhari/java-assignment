import shapes.Shape;
import shapes.Circle;
import shapes.Rectangle;

public class Q2_ShapeDemo {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 6);

        System.out.println("Circle area: " + c.area() + ", perimeter: " + c.perimeter());
        System.out.println("Rectangle area: " + r.area() + ", perimeter: " + r.perimeter());
    }
}
