// WAP to demonstrate method overloading and method overriding

class Printer {
    // Overloading: same method name, different parameters
    void print(int num) {
        System.out.println("Printing int: " + num);
    }

    void print(String text) {
        System.out.println("Printing String: " + text);
    }

    void print(int num, String text) {
        System.out.println("Printing int and String: " + num + " " + text);
    }
}

class ColorPrinter extends Printer {
    // Overriding: same signature as parent
    @Override
    void print(int num) {
        System.out.println("ColorPrinter printing int: " + num);
    }
}

public class overloading_overriding {
    public static void main(String[] args) {
        Printer p1 = new Printer();
        p1.print(10);
        p1.print("Hello");
        p1.print(10, "Hello");

        Printer p2 = new ColorPrinter();
        p2.print(20);
    }
}
