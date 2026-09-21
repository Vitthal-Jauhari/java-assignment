// Q6: Daemon Threads - Auto-save runs in background while main thread performs file processing.

public class Q6_DaemonThread {
    public static void main(String[] args) {
        Thread autoSaveThread = new Thread(() -> {
            while (true) {
                System.out.println("[Daemon] Auto-Save in progress...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        // Set as daemon thread before starting
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        System.out.println("[Main] File processing task started...");
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Main] Processing file batch " + i + " of 5...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Main processing interrupted");
            }
        }

        System.out.println("[Main] File processing task finished. Program terminating.");
    }
}
