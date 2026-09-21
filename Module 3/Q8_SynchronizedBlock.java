// Q8: Synchronized Block - Inventory management where multiple threads decrease stock count.

class Inventory {
    private int stock;

    public Inventory(int initialStock) {
        this.stock = initialStock;
    }

    public void reduceStock(String worker, int quantity) {
        // Only the critical section updating stock is synchronized
        synchronized (this) {
            if (stock >= quantity) {
                System.out.println(worker + " is processing order for " + quantity + " units.");
                stock -= quantity;
                System.out.println(worker + " completed. Remaining stock: " + stock);
            } else {
                System.out.println(worker + " cannot fulfill " + quantity + " units. Current stock: " + stock);
            }
        }
    }

    public int getStock() {
        return stock;
    }
}

public class Q8_SynchronizedBlock {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(10);

        Thread t1 = new Thread(() -> inventory.reduceStock("Worker-A", 4));
        Thread t2 = new Thread(() -> inventory.reduceStock("Worker-B", 5));
        Thread t3 = new Thread(() -> inventory.reduceStock("Worker-C", 3));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }

        System.out.println("Final inventory count: " + inventory.getStock());
    }
}
