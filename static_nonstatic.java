// Write a program to demonstrate the use of static and non-static methods

class MathHelper {
    static int square(int n) {
        return n * n;
    }

    int cube(int n) {
        return n * n * n;
    }
}

public class static_nonstatic {
    public static void main(String[] args) {
        // Static method called directly using class name
        System.out.println("Square: " + MathHelper.square(5));

        // Non-static method requires an object
        MathHelper helper = new MathHelper();
        System.out.println("Cube: " + helper.cube(5));
    }
}
