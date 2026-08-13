// Create a program to show run-time polymorphism using dynamic method dispatch

class Instrument {
    void play() {
        System.out.println("Playing an instrument");
    }
}

class Guitar extends Instrument {
    @Override
    void play() {
        System.out.println("Playing the guitar");
    }
}

class Piano extends Instrument {
    @Override
    void play() {
        System.out.println("Playing the piano");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Instrument obj; // parent reference

        obj = new Guitar();
        obj.play(); // resolved at runtime based on actual object

        obj = new Piano();
        obj.play(); // resolved at runtime based on actual object
    }
}
