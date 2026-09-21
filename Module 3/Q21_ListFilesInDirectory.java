// Q21: Listing all files in a directory with exception handling.

import java.io.File;
import java.util.Scanner;

public class Q21_ListFilesInDirectory {
    public static void listFiles(String path) {
        try {
            File dir = new File(path);

            if (!dir.exists()) {
                System.out.println("Error: The specified path does not exist.");
                return;
            }

            if (!dir.isDirectory()) {
                System.out.println("Error: The path is not a directory.");
                return;
            }

            File[] filesList = dir.listFiles();
            if (filesList == null) {
                System.out.println("Error: Unable to access directory contents (I/O error or permissions).");
                return;
            }

            System.out.println("\nContents of directory: " + dir.getAbsolutePath());
            System.out.println("--------------------------------------------------");
            int fileCount = 0;
            int dirCount = 0;

            for (File file : filesList) {
                if (file.isDirectory()) {
                    System.out.println("[DIR]  " + file.getName());
                    dirCount++;
                } else {
                    System.out.println("[FILE] " + file.getName() + " (" + file.length() + " bytes)");
                    fileCount++;
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Total: " + fileCount + " files, " + dirCount + " directories.");

        } catch (SecurityException se) {
            System.out.println("Security error: Permission denied to read directory. " + se.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String path;
        if (args.length > 0) {
            path = args[0];
        } else {
            System.out.print("Enter directory path (press Enter for current directory '.'): ");
            Scanner scanner = new Scanner(System.in);
            path = scanner.nextLine().trim();
            if (path.isEmpty()) {
                path = ".";
            }
        }
        listFiles(path);
    }
}
