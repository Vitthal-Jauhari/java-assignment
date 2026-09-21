// Q9: Deadlock Example with Dining Philosophers where two philosophers cause deadlock acquiring chopsticks.

class Chopstick {
    private final int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

public class Q9_DiningPhilosophersDeadlock {
    public static void main(String[] args) {
        Chopstick chopstick1 = new Chopstick(1);
        Chopstick chopstick2 = new Chopstick(2);

        // Philosopher 1 attempts to lock chopstick1, then chopstick2
        Thread philosopher1 = new Thread(() -> {
            synchronized (chopstick1) {
                System.out.println("Philosopher 1 picked up Chopstick 1.");
                try {
                    Thread.sleep(100); // Allow philosopher 2 to pick up chopstick 2
                } catch (InterruptedException e) {
                    System.out.println("Philosopher 1 interrupted");
                }
                System.out.println("Philosopher 1 waiting for Chopstick 2...");
                synchronized (chopstick2) {
                    System.out.println("Philosopher 1 picked up Chopstick 2 and is eating.");
                }
            }
        });

        // Philosopher 2 attempts to lock chopstick2, then chopstick1 (reverse order -> deadlock)
        Thread philosopher2 = new Thread(() -> {
            synchronized (chopstick2) {
                System.out.println("Philosopher 2 picked up Chopstick 2.");
                try {
                    Thread.sleep(100); // Allow philosopher 1 to pick up chopstick 1
                } catch (InterruptedException e) {
                    System.out.println("Philosopher 2 interrupted");
                }
                System.out.println("Philosopher 2 waiting for Chopstick 1...");
                synchronized (chopstick1) {
                    System.out.println("Philosopher 2 picked up Chopstick 1 and is eating.");
                }
            }
        });

        System.out.println("Starting simulation (Demonstrating Deadlock)...");
        philosopher1.start();
        philosopher2.start();
    }
}
