// Q17: Reading a file using character stream (FileReader).

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q17_FileReaderDemo {
    public static void main(String[] args) {
        String fileName = "sample_char.txt";

        // Create a sample file first
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Java FileReader Character Stream Demonstration.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
            return;
        }

        // Read using FileReader
        System.out.println("Reading '" + fileName + "' using FileReader:");
        try (FileReader reader = new FileReader(fileName)) {
            int charData;
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
