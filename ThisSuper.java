// WAP to showcase the use of this and super keywords

class Vehicle {
    String type = "Vehicle";

    Vehicle() {
        System.out.println("Vehicle constructor called");
    }

    void display() {
        System.out.println("Type: " + type);
    }
}

class Bike extends Vehicle {
    String type = "Bike";

    Bike() {
        super();
        System.out.println("Bike constructor called");
    }

    void display() {
        System.out.println("this.type: " + this.type);
        System.out.println("super.type: " + super.type);
        super.display();
    }
}

public class ThisSuper {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.display();
    }
}
