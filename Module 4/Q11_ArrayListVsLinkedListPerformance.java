// Q11: Performance comparison between ArrayList and LinkedList for:
// a. Adding elements at the beginning
// b. Removing elements from the middle
// c. Iterating through the list

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q11_ArrayListVsLinkedListPerformance {
    private static final int NUM_ELEMENTS = 50000;

    public static void main(String[] args) {
        System.out.println("Benchmark with " + NUM_ELEMENTS + " operations:");
        System.out.println("-------------------------------------------------------");

        // a. Adding elements at the beginning
        List<Integer> arrayListA = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            arrayListA.add(0, i);
        }
        long durationArrayListAdd = (System.nanoTime() - start) / 1_000_000;

        List<Integer> linkedListA = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            linkedListA.add(0, i);
        }
        long durationLinkedListAdd = (System.nanoTime() - start) / 1_000_000;

        System.out.println("a. Adding at beginning (index 0):");
        System.out.println("   ArrayList : " + durationArrayListAdd + " ms (O(N) shifts)");
        System.out.println("   LinkedList: " + durationLinkedListAdd + " ms (O(1) pointer update)");

        // b. Removing elements from the middle
        start = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            arrayListA.remove(arrayListA.size() / 2);
        }
        long durationArrayListRemove = (System.nanoTime() - start) / 1_000_000;

        start = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            linkedListA.remove(linkedListA.size() / 2);
        }
        long durationLinkedListRemove = (System.nanoTime() - start) / 1_000_000;

        System.out.println("\nb. Removing 5,000 elements from middle:");
        System.out.println("   ArrayList : " + durationArrayListRemove + " ms (fast arraycopy shift)");
        System.out.println("   LinkedList: " + durationLinkedListRemove + " ms (O(N) traversal to node)");

        // c. Iterating through the list using enhanced for-loop
        start = System.nanoTime();
        long sumArray = 0;
        for (int num : arrayListA) {
            sumArray += num;
        }
        long durationArrayListIter = (System.nanoTime() - start) / 1_000_000;

        start = System.nanoTime();
        long sumLinked = 0;
        for (int num : linkedListA) {
            sumLinked += num;
        }
        long durationLinkedListIter = (System.nanoTime() - start) / 1_000_000;

        System.out.println("\nc. Iterating through entire list:");
        System.out.println("   ArrayList : " + durationArrayListIter + " ms (cache friendly)");
        System.out.println("   LinkedList: " + durationLinkedListIter + " ms (pointer chasing)");
    }
}
