// Create a class hierarchy for animals that demonstrates polymorphism

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

class Cow extends Animal {
    @Override
    void sound() {
        System.out.println("Cow moos");
    }
}

public class animal_hierarchy {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Cow();
        Animal a4 = new Animal();

        a1.sound();
        a2.sound();
        a3.sound();
        a4.sound();
    }
}
