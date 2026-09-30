// Q16: Demonstrating sorted order of keys in TreeMap by adding unsorted key-value pairs.

import java.util.Map;
import java.util.TreeMap;

public class Q16_TreeMapSorting {
    public static void main(String[] args) {
        // TreeMap automatically sorts entries based on the natural ordering of keys (Red-Black tree)
        Map<Integer, String> rollNumberMap = new TreeMap<>();

        System.out.println("Adding unsorted entries: 105, 101, 109, 103, 102, 108...");
        rollNumberMap.put(105, "Edward");
        rollNumberMap.put(101, "Alice");
        rollNumberMap.put(109, "Ian");
        rollNumberMap.put(103, "Charlie");
        rollNumberMap.put(102, "Bob");
        rollNumberMap.put(108, "Hannah");

        System.out.println("\nTreeMap Iteration (keys sorted naturally in ascending order):");
        for (Map.Entry<Integer, String> entry : rollNumberMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " -> Name: " + entry.getValue());
        }
    }
}
