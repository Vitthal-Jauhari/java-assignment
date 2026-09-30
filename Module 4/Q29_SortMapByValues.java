// Q29: Sort a Map by its values using a custom Comparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Q29_SortMapByValues {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean ascending) {
        List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list of entries using a comparator on values
        entryList.sort((e1, e2) -> {
            if (ascending) {
                return e1.getValue().compareTo(e2.getValue());
            } else {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // Insert into LinkedHashMap to preserve the sorted order
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> itemStock = new HashMap<>();
        itemStock.put("Keyboard", 35);
        itemStock.put("Monitor", 12);
        itemStock.put("Mouse", 80);
        itemStock.put("Laptop", 5);
        itemStock.put("Headphones", 22);

        System.out.println("Original Map: " + itemStock);

        // Sort Ascending by Value
        Map<String, Integer> sortedAsc = sortByValue(itemStock, true);
        System.out.println("\nMap Sorted by Value (Ascending):");
        sortedAsc.forEach((k, v) -> System.out.println("  " + k + " : " + v));

        // Sort Descending by Value
        Map<String, Integer> sortedDesc = sortByValue(itemStock, false);
        System.out.println("\nMap Sorted by Value (Descending):");
        sortedDesc.forEach((k, v) -> System.out.println("  " + k + " : " + v));
    }
}
