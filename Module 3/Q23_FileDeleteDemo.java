// Q23: Deleting a file from the file system using the File class.

import java.io.File;
import java.io.IOException;

public class Q23_FileDeleteDemo {
    public static void main(String[] args) {
        String fileName = "file_to_delete.txt";
        File file = new File(fileName);

        try {
            // First ensure file exists by creating it
            if (file.createNewFile()) {
                System.out.println("Temporary file created: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }

            // Delete the file
            System.out.println("Attempting to delete: " + file.getName());
            if (file.delete()) {
                System.out.println("Success: File '" + fileName + "' was deleted successfully.");
            } else {
                System.out.println("Failure: Could not delete '" + fileName + "'.");
            }

            // Verify deletion
            if (!file.exists()) {
                System.out.println("Verification: File no longer exists in the file system.");
            }

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
