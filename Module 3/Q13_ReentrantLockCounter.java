// Q13: ReentrantLock vs No Lock counter comparison under multithreading.

import java.util.concurrent.locks.ReentrantLock;

class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class SafeCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class Q13_ReentrantLockCounter {
    public static void main(String[] args) throws InterruptedException {
        int incrementsPerThread = 10000;

        // Test Unsafe Counter
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) unsafeCounter.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) unsafeCounter.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected count: " + (incrementsPerThread * 2));
        System.out.println("Unsafe counter count: " + unsafeCounter.getCount() + " (shows race condition)");

        // Test Safe Counter with ReentrantLock
        SafeCounter safeCounter = new SafeCounter();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) safeCounter.increment();
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < incrementsPerThread; i++) safeCounter.increment();
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("Safe counter with ReentrantLock: " + safeCounter.getCount() + " (thread-safe)");
    }
}
