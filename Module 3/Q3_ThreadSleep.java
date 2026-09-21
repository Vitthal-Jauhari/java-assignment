// Q3: Thread Sleep Method - Thread 1 prints every 1s, Thread 2 prints every 2s.

public class Q3_ThreadSleep {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1 (tick " + i + ")");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrupted");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 2 (tick " + i + ")");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 interrupted");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
