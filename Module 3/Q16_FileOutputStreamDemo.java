// Q16: Writing a string to a file named output.txt using FileOutputStream.

import java.io.FileOutputStream;
import java.io.IOException;

public class Q16_FileOutputStreamDemo {
    public static void main(String[] args) {
        String data = "Java I/O Streams Example";
        String fileName = "output.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Successfully wrote to " + fileName);
            System.out.println("Data written: " + data);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
