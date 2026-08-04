// Create a program that initializes class fields using a parameterized constructor

class Laptop {
    String brand;
    double price;
    int ram;

    Laptop(String brand, double price, int ram) {
        this.brand = brand;
        this.price = price;
        this.ram = ram;
    }

    void display() {
        System.out.println(brand + " -> Rs. " + price + ", " + ram + "GB RAM");
    }
}

public class ParameterizedConstructor {
    public static void main(String[] args) {
        Laptop l1 = new Laptop("Dell", 55000.0, 8);
        Laptop l2 = new Laptop("HP", 62000.0, 16);

        l1.display();
        l2.display();
    }
}
