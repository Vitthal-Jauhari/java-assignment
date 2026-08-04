// Show an example of the final keyword for variables, methods, and classes

class Parent {
    final int id = 100;

    final void show() {
        System.out.println("This method cannot be overridden");
    }
}

class Child extends Parent {
    // show() cannot be overridden here since it is final
}

final class Utility {
    static void greet() {
        System.out.println("Utility class cannot be extended");
    }
}

public class final_keyword {
    public static void main(String[] args) {
        final int maxLimit = 500;
        System.out.println("Final variable: " + maxLimit);

        Child c = new Child();
        c.show();
        System.out.println("Final field: " + c.id);

        Utility.greet();
    }
}
