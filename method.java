// Write a program to demonstrate Method overloading and Method overriding.

class Person {
    void work() {
        System.out.println("Person works");
    }
}

class Teacher extends Person {
    @Override
    void work() {
        System.out.println("Teacher teaches");
    }
}

class Calculator {
    // Method Overloading
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

public class Method {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println("Overloading:");
        System.out.println(c.sum(10, 20));
        System.out.println(c.sum(10, 20, 30));

        System.out.println("\nOverriding:");
        Person p = new Teacher();
        p.work();
    }
}