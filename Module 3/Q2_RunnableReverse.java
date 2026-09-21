// Q2: Create a thread by implementing Runnable that prints characters of "MULTITHREADING" in reverse order.

class ReverseStringRunnable implements Runnable {
    private String text;

    public ReverseStringRunnable(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        System.out.print("Reversed string: ");
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i) + " ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
        System.out.println();
    }
}

public class Q2_RunnableReverse {
    public static void main(String[] args) {
        String str = "MULTITHREADING";
        Thread thread = new Thread(new ReverseStringRunnable(str));
        thread.start();
    }
}
