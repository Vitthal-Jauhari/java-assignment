// Write a program to demonstrate multilevel inheritance in Java

class Person {
    void display() {
        System.out.println("This is a person");
    }
}

class Employee extends Person {
    void work() {
        System.out.println("Employee is working");
    }
}

class Manager extends Employee {
    void manage() {
        System.out.println("Manager is managing the team");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display();
        m.work();
        m.manage();
    }
}
