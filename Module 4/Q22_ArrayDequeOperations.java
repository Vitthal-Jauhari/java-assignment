// Q22: Deque implementation using ArrayDeque performing:
// a. Add elements at both ends
// b. Remove elements from both ends
// c. Peek at both ends

import java.util.ArrayDeque;
import java.util.Deque;

public class Q22_ArrayDequeOperations {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // a. Add elements at both ends
        deque.addFirst("Front-1");
        deque.addFirst("Front-2");
        deque.addLast("Back-1");
        deque.addLast("Back-2");

        System.out.println("Deque after addFirst and addLast: " + deque);

        // c. Peek at both ends
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast() : " + deque.peekLast());

        // b. Remove elements from both ends
        System.out.println("\nremoveFirst(): " + deque.removeFirst());
        System.out.println("removeLast() : " + deque.removeLast());

        System.out.println("Deque after removals: " + deque);
    }
}
