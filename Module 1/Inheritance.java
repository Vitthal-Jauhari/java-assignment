// WAP to demonstrate Inheritance and polymorphism

class Car {
    void start() {
        System.out.println("Car is starting");
    }
}

class Baleno extends Car {
    @Override
    void start() {
        System.out.println("Baleno is starting");
    }
}

class Swift extends Car {
    @Override
    void start() {
        System.out.println("Swift is starting");
    }
}

class Honda extends Car {
    @Override
    void start() {
        System.out.println("Honda is starting");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        // Polymorphism: Parent reference can hold child objects
        Car car1 = new Baleno();
        Car car2 = new Swift();
        Car car3 = new Honda();
        Car car4 = new Car();
        
        car1.start();
        car2.start();
        car3.start();
        car4.start();
    }
}

