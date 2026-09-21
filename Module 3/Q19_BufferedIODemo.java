// Q19: Buffered I/O - Using BufferedReader and BufferedWriter for efficient reading and writing.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q19_BufferedIODemo {
    public static void main(String[] args) {
        String fileName = "buffered_example.txt";

        // Writing using BufferedWriter
        System.out.println("Writing to " + fileName + " using BufferedWriter...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Line 1: High-performance buffered writing.");
            writer.newLine();
            writer.write("Line 2: Buffered character streams reduce disk I/O operations.");
            writer.newLine();
            writer.write("Line 3: Java I/O provides smooth and efficient stream processing.");
            System.out.println("Write completed.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading using BufferedReader
        System.out.println("\nReading from " + fileName + " using BufferedReader:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("[" + lineNumber++ + "] " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
