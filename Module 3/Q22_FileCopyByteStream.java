// Q22: Copying file contents from source to destination using byte streams.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Q22_FileCopyByteStream {
    public static void main(String[] args) {
        String sourceFile = "source_copy.txt";
        String destinationFile = "destination_copy.txt";

        // Create a sample source file if not present
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write("This content is being copied using Java Byte Streams (FileInputStream and FileOutputStream).\nLine 2: Fast block buffer copying.");
        } catch (IOException e) {
            System.out.println("Error initializing source file: " + e.getMessage());
            return;
        }

        // Copy file
        System.out.println("Copying from '" + sourceFile + "' to '" + destinationFile + "'...");
        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("File copied successfully! Total bytes copied: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
