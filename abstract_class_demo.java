// Implement an abstract class and override its methods in a subclass

abstract class Appliance {
    abstract void turnOn();

    void info() {
        System.out.println("This is an appliance");
    }
}

class WashingMachine extends Appliance {
    @Override
    void turnOn() {
        System.out.println("Washing machine is turning on");
    }
}

public class abstract_class_demo {
    public static void main(String[] args) {
        Appliance a = new WashingMachine();
        a.info();
        a.turnOn();
    }
}
