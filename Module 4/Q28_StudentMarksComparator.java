// Q28: Sort a list of custom objects (Student with name and marks) using a Comparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private final String name;
    private final double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return String.format("Student(name='%s', marks=%.1f)", name, marks);
    }
}

public class Q28_StudentMarksComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 88.5));
        students.add(new Student("Bob", 92.0));
        students.add(new Student("Charlie", 79.5));
        students.add(new Student("Diana", 95.0));
        students.add(new Student("Evan", 88.5));

        System.out.println("Original Student List:");
        students.forEach(System.out::println);

        // Sort by Marks Descending (highest score first)
        Comparator<Student> marksDesc = (s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks());
        Collections.sort(students, marksDesc);
        System.out.println("\nSorted by Marks (Descending):");
        students.forEach(System.out::println);

        // Sort by Name Alphabetically
        Comparator<Student> nameAsc = Comparator.comparing(Student::getName);
        Collections.sort(students, nameAsc);
        System.out.println("\nSorted by Name (Alphabetical):");
        students.forEach(System.out::println);
    }
}
