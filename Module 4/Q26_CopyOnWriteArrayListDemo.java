// Q26: Using CopyOnWriteArrayList to iterate and modify a list safely in a multithreaded environment.

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q26_CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        // Thread 1: Iterating over snapshot of list
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader thread starting iteration:");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println("Reader observed: " + iterator.next());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
            }
            System.out.println("Reader iteration complete.");
        });

        // Thread 2: Concurrently modifying the list (creates a fresh copy internally)
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(25);
            } catch (InterruptedException ignored) {}
            System.out.println("Writer adding 'Yellow'...");
            list.add("Yellow");
            System.out.println("Writer adding 'Purple'...");
            list.add("Purple");
        });

        readerThread.start();
        writerThread.start();

        readerThread.join();
        writerThread.join();

        System.out.println("\nFinal list state after concurrent write: " + list);
        System.out.println("Notice: No ConcurrentModificationException was thrown!");
    }
}
