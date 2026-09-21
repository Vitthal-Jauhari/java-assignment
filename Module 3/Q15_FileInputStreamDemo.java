// Q15: Reading a text file using byte stream (FileInputStream).

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Q15_FileInputStreamDemo {
    public static void main(String[] args) {
        String fileName = "sample_byte.txt";

        // Create a sample file first if it doesn't exist
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, World from FileInputStream byte stream!");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
            return;
        }

        // Read using FileInputStream
        System.out.println("Reading '" + fileName + "' using FileInputStream:");
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
