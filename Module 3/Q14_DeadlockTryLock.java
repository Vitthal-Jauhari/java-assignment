// Q14: Deadlock prevention using ReentrantLock.tryLock() with timeout.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Q14_DeadlockTryLock {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    static void executeWithTryLock(String threadName, ReentrantLock firstLock, ReentrantLock secondLock) {
        while (true) {
            boolean acquiredFirst = false;
            boolean acquiredSecond = false;
            try {
                acquiredFirst = firstLock.tryLock(50, TimeUnit.MILLISECONDS);
                if (acquiredFirst) {
                    System.out.println(threadName + " acquired first lock.");
                    Thread.sleep(20); // Small delay before trying second lock

                    acquiredSecond = secondLock.tryLock(50, TimeUnit.MILLISECONDS);
                    if (acquiredSecond) {
                        System.out.println(threadName + " acquired both locks. Critical work performed!");
                        break; // Successfully finished
                    } else {
                        System.out.println(threadName + " could not acquire second lock. Backing off...");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted: " + e.getMessage());
            } finally {
                if (acquiredSecond) {
                    secondLock.unlock();
                }
                if (acquiredFirst) {
                    firstLock.unlock();
                }
            }

            // Sleep briefly before retrying to prevent livelock
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting threads with tryLock timeout to prevent deadlock...");

        Thread t1 = new Thread(() -> executeWithTryLock("Thread-1", lock1, lock2));
        Thread t2 = new Thread(() -> executeWithTryLock("Thread-2", lock2, lock1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }

        System.out.println("Both threads completed successfully without deadlocking.");
    }
}
