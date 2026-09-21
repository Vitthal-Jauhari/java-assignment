// Q5: Thread Naming and Priority demonstration with Worker-1, Worker-2, and Worker-3.

class PriorityWorker extends Thread {
    public PriorityWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " (Priority: " + getPriority() + ") executing step " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class Q5_ThreadPriority {
    public static void main(String[] args) {
        PriorityWorker w1 = new PriorityWorker("Worker-1");
        PriorityWorker w2 = new PriorityWorker("Worker-2");
        PriorityWorker w3 = new PriorityWorker("Worker-3");

        w1.setPriority(Thread.MIN_PRIORITY);  // 1
        w2.setPriority(Thread.NORM_PRIORITY); // 5
        w3.setPriority(Thread.MAX_PRIORITY);  // 10

        System.out.println("Starting threads with assigned priorities...");
        w1.start();
        w2.start();
        w3.start();
    }
}
