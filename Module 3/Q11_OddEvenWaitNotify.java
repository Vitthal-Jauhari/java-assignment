// Q11: Two threads print numbers from 1 to 20 alternately (odd and even) using wait() and notify().

class NumberPrinter {
    private int number = 1;
    private final int limit = 20;

    public synchronized void printOdd() {
        while (number <= limit) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                System.out.println("Odd Thread : " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= limit) {
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                System.out.println("Even Thread: " + number);
                number++;
                notify();
            }
        }
    }
}

public class Q11_OddEvenWaitNotify {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}
