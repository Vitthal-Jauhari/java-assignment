// Write a program to create a class with multiple constructors (constructor overloading)

class Employee {
    String name;
    double salary;

    Employee() {
        name = "Unknown";
        salary = 0.0;
    }

    Employee(String name) {
        this.name = name;
        this.salary = 0.0;
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(name + " earns Rs. " + salary);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Vitthal");
        Employee e3 = new Employee("Ark", 50000.0);

        e1.display();
        e2.display();
        e3.display();
    }
}
