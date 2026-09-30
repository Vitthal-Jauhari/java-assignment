// Q34: Merge two PriorityQueue objects and sort the resulting queue.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q34_MergePriorityQueues {

    public static PriorityQueue<Integer> mergeQueues(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        PriorityQueue<Integer> merged = new PriorityQueue<>(pq1);
        merged.addAll(pq2);
        return merged;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.offer(45);
        pq1.offer(12);
        pq1.offer(89);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.offer(23);
        pq2.offer(5);
        pq2.offer(67);
        pq2.offer(38);

        System.out.println("PriorityQueue 1 elements: " + pq1);
        System.out.println("PriorityQueue 2 elements: " + pq2);

        // Merge the two PriorityQueues
        PriorityQueue<Integer> mergedPq = mergeQueues(pq1, pq2);

        System.out.println("\nMerged PriorityQueue size: " + mergedPq.size());

        // Extract in sorted ascending order (as guaranteed by min-heap PriorityQueue)
        System.out.println("\nExtracting merged elements in sorted order (via poll()):");
        List<Integer> sortedList = new ArrayList<>();
        while (!mergedPq.isEmpty()) {
            sortedList.add(mergedPq.poll());
        }
        System.out.println("Sorted output: " + sortedList);
    }
}
