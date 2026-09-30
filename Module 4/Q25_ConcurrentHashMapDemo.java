// Q25: ConcurrentHashMap demonstration handling concurrent reads, writes, and modifications safely.

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Q25_ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 4 concurrent tasks incrementing word occurrences
        for (int i = 0; i < 4; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 500; j++) {
                    // Atomic compute if present / merge
                    wordCounts.merge("Java", 1, Integer::sum);
                    wordCounts.merge("Concurrency", 1, Integer::sum);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Concurrent updates completed successfully without locking the entire table:");
        System.out.println("Java count       : " + wordCounts.get("Java") + " (Expected 2000)");
        System.out.println("Concurrency count: " + wordCounts.get("Concurrency") + " (Expected 2000)");

        // Concurrent iteration and modification without ConcurrentModificationException
        System.out.println("\nIterating while concurrently inserting new key:");
        for (String key : wordCounts.keySet()) {
            if (key.equals("Java")) {
                wordCounts.put("Collections", 500); // Safe in ConcurrentHashMap
            }
            System.out.println("Found key: " + key + " -> " + wordCounts.get(key));
        }
    }
}
