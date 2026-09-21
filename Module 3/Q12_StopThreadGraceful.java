// Q12: Gracefully stopping a thread using a volatile flag during file download simulation.

class FileDownloader implements Runnable {
    // volatile ensures changes to running are immediately visible to the downloader thread
    private volatile boolean running = true;

    public void stopDownload() {
        running = false;
    }

    @Override
    public void run() {
        int chunk = 1;
        while (running && chunk <= 10) {
            System.out.println("Downloading chunk " + chunk + "...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Download thread interrupted");
                break;
            }
            chunk++;
        }

        if (!running) {
            System.out.println("Download stopped gracefully by user request.");
        } else {
            System.out.println("Download completed successfully!");
        }
    }
}

public class Q12_StopThreadGraceful {
    public static void main(String[] args) {
        FileDownloader downloader = new FileDownloader();
        Thread downloadThread = new Thread(downloader);

        downloadThread.start();

        // Let download run for 2 seconds, then stop it
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }

        System.out.println("Sending stop signal to download thread...");
        downloader.stopDownload();
    }
}
