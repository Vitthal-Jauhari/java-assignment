// Q27: Demonstrating utility methods in java.util.Collections:
// 1. shuffle() and sort()
// 2. unmodifiableList() with modification check
// 3. binarySearch()
// 4. frequency()

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q27_CollectionsUtilityDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(40, 10, 30, 20, 50, 20, 10, 20));
        System.out.println("Initial List: " + list);

        // 1. sort()
        Collections.sort(list);
        System.out.println("\n1. After Collections.sort(): " + list);

        // 2. binarySearch() on sorted list
        int target = 30;
        int index = Collections.binarySearch(list, target);
        System.out.println("\n2. Collections.binarySearch(list, " + target + "): Found at index " + index);

        // 3. frequency()
        int freqElement = 20;
        int count = Collections.frequency(list, freqElement);
        System.out.println("\n3. Collections.frequency(list, " + freqElement + "): " + count + " occurrences");

        // 4. shuffle()
        Collections.shuffle(list);
        System.out.println("\n4. After Collections.shuffle(): " + list);

        // 5. unmodifiableList()
        List<String> mutableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("\n5. Created unmodifiable list: " + unmodifiableList);

        try {
            System.out.println("Attempting to add 'D' to unmodifiable list...");
            unmodifiableList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught Expected Exception: UnsupportedOperationException cannot modify read-only view.");
        }
    }
}
