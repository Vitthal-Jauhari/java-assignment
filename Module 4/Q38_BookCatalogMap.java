// Q38: Book catalog system using HashMap (titles as keys, author names as values) with search by title.

import java.util.HashMap;
import java.util.Map;

class BookCatalog {
    private final Map<String, String> catalog = new HashMap<>();

    public void addBook(String title, String author) {
        catalog.put(title.trim(), author.trim());
        System.out.println("Cataloged: \"" + title + "\" by " + author);
    }

    public void searchByTitle(String titleQuery) {
        System.out.println("\nSearching catalog for: \"" + titleQuery + "\"");
        boolean found = false;
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(titleQuery.trim()) ||
                entry.getKey().toLowerCase().contains(titleQuery.toLowerCase().trim())) {
                System.out.println("  Found: \"" + entry.getKey() + "\" | Author: " + entry.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No books found matching \"" + titleQuery + "\".");
        }
    }

    public void displayAllBooks() {
        System.out.println("\n--- Complete Book Catalog (" + catalog.size() + " books) ---");
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            System.out.printf("\"%-35s\" by %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------------------\n");
    }
}

public class Q38_BookCatalogMap {
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        catalog.addBook("Clean Code", "Robert C. Martin");
        catalog.addBook("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        catalog.addBook("Effective Java", "Joshua Bloch");
        catalog.addBook("Java Concurrency in Practice", "Brian Goetz");
        catalog.addBook("Introduction to Algorithms", "Thomas H. Cormen");

        catalog.displayAllBooks();

        catalog.searchByTitle("Effective Java");
        catalog.searchByTitle("Java");
        catalog.searchByTitle("Nonexistent Book");
    }
}
