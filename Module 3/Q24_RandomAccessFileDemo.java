// Q24: Using RandomAccessFile to read and write at specific positions within a file.

import java.io.IOException;
import java.io.RandomAccessFile;

public class Q24_RandomAccessFileDemo {
    public static void main(String[] args) {
        String fileName = "random_access_test.txt";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Write initial data at the beginning (position 0)
            raf.seek(0);
            raf.writeBytes("Hello World! Welcome to Java.");
            System.out.println("Initial content written at position 0.");

            // Read the full line back
            raf.seek(0);
            System.out.println("Current content: " + raf.readLine());

            // Seek to index 6 (where 'World' begins) and overwrite with 'Universe'
            raf.seek(6);
            raf.writeBytes("Universe");
            System.out.println("Overwrote bytes starting at offset 6 with 'Universe'.");

            // Read again from start
            raf.seek(0);
            System.out.println("Updated content: " + raf.readLine());

        } catch (IOException e) {
            System.out.println("RandomAccessFile error: " + e.getMessage());
        }
    }
}
