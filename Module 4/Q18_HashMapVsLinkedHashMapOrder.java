// Q18: Difference between HashMap and LinkedHashMap in terms of iteration order.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q18_HashMapVsLinkedHashMapOrder {
    public static void main(String[] args) {
        String[] keys = {"Zebra", "Monkey", "Elephant", "Lion", "Giraffe", "Bear"};
        int val = 1;

        // HashMap: Order is determined by internal hash buckets and may appear arbitrary
        Map<String, Integer> hashMap = new HashMap<>();
        for (String k : keys) {
            hashMap.put(k, val++);
        }

        val = 1;
        // LinkedHashMap: Preserves the exact sequence in which entries were inserted
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String k : keys) {
            linkedHashMap.put(k, val++);
        }

        System.out.println("Inserted order: [Zebra, Monkey, Elephant, Lion, Giraffe, Bear]");

        System.out.println("\nLinkedHashMap Order (Guaranteed insertion order):");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nHashMap Order (Hash bucket distribution - order not guaranteed):");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
