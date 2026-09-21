// Q1: Create a thread by extending the Thread class that prints even numbers from 2 to 20 with a 500ms delay.

class EvenNumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class Q1_ThreadExtend {
    public static void main(String[] args) {
        EvenNumberThread t1 = new EvenNumberThread();
        t1.start();
    }
}
