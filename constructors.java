// Demonstrate the concept of constructors in OOP with a program

class Book {
    String title;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    void display() {
        System.out.println(title + " -> Rs. " + price);
    }
}

public class constructors {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", 499.0);

        b1.display();
        b2.display();
    }
}
