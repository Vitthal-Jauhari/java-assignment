// Q09: Generic method to print all elements of any Collection (List, Set, Queue, etc.).

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q09_PrintAnyCollection {

    public static <T> void printCollection(Collection<T> collection, String collectionName) {
        System.out.println("Printing " + collectionName + " (size " + collection.size() + "):");
        System.out.print("[ ");
        for (T element : collection) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test with List
        List<String> list = Arrays.asList("Java", "Python", "C++", "Go");
        printCollection(list, "List of Strings");

        // Test with Set
        Set<Integer> set = new HashSet<>(Arrays.asList(100, 200, 300, 400));
        printCollection(set, "Set of Integers");

        // Test with Queue
        Queue<Double> queue = new ArrayDeque<>(Arrays.asList(1.1, 2.2, 3.3));
        printCollection(queue, "Queue of Doubles");
    }
}
