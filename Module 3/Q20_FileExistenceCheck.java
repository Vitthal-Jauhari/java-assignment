// Q20: File existence check and file creation using File class.

import java.io.File;
import java.io.IOException;

public class Q20_FileExistenceCheck {
    public static void main(String[] args) {
        String fileName = "check_existence.txt";
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("The file '" + fileName + "' already exists.");
            System.out.println("Absolute path: " + file.getAbsolutePath());
        } else {
            System.out.println("The file '" + fileName + "' does not exist. Creating it now...");
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File created successfully at: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed to create the file.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        }
    }
}
