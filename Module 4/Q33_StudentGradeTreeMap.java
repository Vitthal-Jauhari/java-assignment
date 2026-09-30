// Q33: Store students' grades in a TreeMap (sorted by student name) with add, remove, and query functionality.

import java.util.Map;
import java.util.TreeMap;

class GradeBook {
    private final Map<String, String> grades = new TreeMap<>();

    public void addGrade(String studentName, String grade) {
        grades.put(studentName, grade);
        System.out.println("Recorded: " + studentName + " -> " + grade);
    }

    public void removeGrade(String studentName) {
        if (grades.containsKey(studentName)) {
            String removed = grades.remove(studentName);
            System.out.println("Removed grade for " + studentName + " (was " + removed + ")");
        } else {
            System.out.println("Error: Student '" + studentName + "' not found in gradebook.");
        }
    }

    public void queryGrade(String studentName) {
        if (grades.containsKey(studentName)) {
            System.out.println("Query Result: " + studentName + " has grade " + grades.get(studentName));
        } else {
            System.out.println("Query Result: Student '" + studentName + "' not found.");
        }
    }

    public void displayAll() {
        System.out.println("\n--- Gradebook (Sorted Alphabetically by Student Name) ---");
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.printf("%-15s : %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------------------------\n");
    }
}

public class Q33_StudentGradeTreeMap {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();

        // Adding student grades (unsorted insertion)
        gradeBook.addGrade("Zack", "B+");
        gradeBook.addGrade("Alice", "A");
        gradeBook.addGrade("Diana", "A-");
        gradeBook.addGrade("Bob", "B");
        gradeBook.addGrade("Charlie", "A+");

        gradeBook.displayAll();

        // Querying
        gradeBook.queryGrade("Alice");
        gradeBook.queryGrade("John");

        // Removing
        gradeBook.removeGrade("Bob");

        gradeBook.displayAll();
    }
}
