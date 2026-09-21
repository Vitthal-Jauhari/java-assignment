// Q18: Writing a string to example.txt using FileWriter.

import java.io.FileWriter;
import java.io.IOException;

public class Q18_FileWriterDemo {
    public static void main(String[] args) {
        String text = "Learning Character Streams in Java with FileWriter.";
        String fileName = "example.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Successfully written to " + fileName);
            System.out.println("Content: " + text);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
