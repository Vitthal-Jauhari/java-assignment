// Q24: Demonstrating the thread-safe nature of Vector by adding elements from multiple concurrent threads.

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Q24_VectorThreadSafety {
    private static final int ELEMENTS_PER_THREAD = 2000;

    public static void main(String[] args) throws InterruptedException {
        // 1. Thread-safe Vector test
        Vector<Integer> safeVector = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < ELEMENTS_PER_THREAD; i++) safeVector.add(i);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < ELEMENTS_PER_THREAD; i++) safeVector.add(i);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected size: " + (ELEMENTS_PER_THREAD * 2));
        System.out.println("Vector size  : " + safeVector.size() + " (Consistent & Thread-safe)");

        // 2. Non-thread-safe ArrayList test for contrast
        List<Integer> unsafeList = new ArrayList<>();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < ELEMENTS_PER_THREAD; i++) unsafeList.add(i);
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < ELEMENTS_PER_THREAD; i++) unsafeList.add(i);
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("ArrayList size: " + unsafeList.size() + " (Inconsistent due to data race)");
    }
}
