// Q15: Iterating over LinkedHashSet demonstrating its insertion-order preservation property.

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q15_LinkedHashSetOrder {
    public static void main(String[] args) {
        String[] sequence = {"Orange", "Banana", "Apple", "Mango", "Grapes", "Pineapple"};

        // LinkedHashSet: Maintains doubly-linked list across hash buckets
        Set<String> linkedHashSet = new LinkedHashSet<>();
        for (String fruit : sequence) {
            linkedHashSet.add(fruit);
        }

        // Standard HashSet: Arbitrary bucket order based on hash codes
        Set<String> hashSet = new HashSet<>();
        for (String fruit : sequence) {
            hashSet.add(fruit);
        }

        System.out.println("Original insertion order: [Orange, Banana, Apple, Mango, Grapes, Pineapple]");
        System.out.println("\nLinkedHashSet iteration (preserves insertion order):");
        for (String fruit : linkedHashSet) {
            System.out.print(fruit + " -> ");
        }
        System.out.println("END");

        System.out.println("\nHashSet iteration (hash-based, order NOT guaranteed):");
        for (String fruit : hashSet) {
            System.out.print(fruit + " -> ");
        }
        System.out.println("END");
    }
}
