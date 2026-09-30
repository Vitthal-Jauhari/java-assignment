// Q35: Generic MultiMap<K, V> class storing multiple values per key using HashMap<K, List<V>>.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MultiMap<K, V> {
    private final Map<K, List<V>> map = new HashMap<>();

    public void put(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public List<V> get(K key) {
        return map.getOrDefault(key, Collections.emptyList());
    }

    public boolean remove(K key, V value) {
        List<V> values = map.get(key);
        if (values != null) {
            boolean removed = values.remove(value);
            if (values.isEmpty()) {
                map.remove(key);
            }
            return removed;
        }
        return false;
    }

    public List<V> removeAll(K key) {
        return map.remove(key);
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public int totalValuesCount() {
        int count = 0;
        for (List<V> list : map.values()) {
            count += list.size();
        }
        return count;
    }

    public void display() {
        System.out.println("MultiMap Content:");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class Q35_GenericMultiMap {
    public static void main(String[] args) {
        MultiMap<String, String> courseEnrollment = new MultiMap<>();

        // Multiple students enrolled in courses
        courseEnrollment.put("CS101", "Alice");
        courseEnrollment.put("CS101", "Bob");
        courseEnrollment.put("CS101", "Charlie");

        courseEnrollment.put("MATH201", "Diana");
        courseEnrollment.put("MATH201", "Evan");

        courseEnrollment.put("PHYS101", "Frank");

        courseEnrollment.display();

        System.out.println("\nStudents in CS101: " + courseEnrollment.get("CS101"));
        System.out.println("Total enrollments: " + courseEnrollment.totalValuesCount());

        // Remove Bob from CS101
        courseEnrollment.remove("CS101", "Bob");
        System.out.println("\nAfter removing Bob from CS101:");
        courseEnrollment.display();
    }
}
