// Write a program to demonstrate final classes and methods

final class Constants {
    static final double PI = 3.14159;
}

class Base {
    final void greet() {
        System.out.println("This method cannot be overridden");
    }
}

class Derived extends Base {
    // greet() cannot be overridden here since it is final
    void extra() {
        System.out.println("Derived class extra method");
    }
}

public class final_class_method {
    public static void main(String[] args) {
        System.out.println("PI value: " + Constants.PI);

        Derived d = new Derived();
        d.greet();
        d.extra();
    }
}
