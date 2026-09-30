// Q14: Demonstrates uniqueness property of HashSet and role of equals() and hashCode().

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Item {
    private final int id;
    private final String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Item(" + id + ", '" + name + "')";
    }
}

public class Q14_HashSetUniqueness {
    public static void main(String[] args) {
        // Simple String uniqueness demonstration
        Set<String> set = new HashSet<>();
        System.out.println("Adding 'Java': " + set.add("Java"));
        System.out.println("Adding 'Python': " + set.add("Python"));
        System.out.println("Adding duplicate 'Java': " + set.add("Java")); // returns false
        System.out.println("Set content: " + set);

        // Custom object uniqueness governed by equals() & hashCode()
        Set<Item> itemSet = new HashSet<>();
        Item item1 = new Item(101, "Laptop");
        Item item2 = new Item(102, "Phone");
        Item duplicateItem = new Item(101, "Laptop"); // distinct instance, identical content

        System.out.println("\nAdding item1: " + itemSet.add(item1));
        System.out.println("Adding item2: " + itemSet.add(item2));
        System.out.println("Adding duplicateItem (same id & name): " + itemSet.add(duplicateItem)); // rejected
        System.out.println("Custom Objects Set size: " + itemSet.size());
        System.out.println("Custom Objects Set content: " + itemSet);
    }
}
