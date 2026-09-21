// Q4: Countdown timer (10 to 1 with 1s delay) while another thread prints "Tick..." every 0.5s.

public class Q4_CountdownTimer {
    public static void main(String[] args) {
        Thread countdownThread = new Thread(() -> {
            for (int i = 10; i >= 1; i--) {
                System.out.println("Countdown: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Countdown interrupted");
                }
            }
            System.out.println("Countdown complete: Liftoff!");
        });

        Thread tickThread = new Thread(() -> {
            while (countdownThread.isAlive()) {
                System.out.println("  Tick...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        countdownThread.start();
        tickThread.start();

        try {
            countdownThread.join();
            tickThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }
    }
}
