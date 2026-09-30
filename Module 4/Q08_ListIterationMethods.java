// Q08: Iterating over a List of integers using:
// a. A simple for loop
// b. An enhanced for loop
// c. A while loop with an Iterator

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q08_ListIterationMethods {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }

        // a. Simple for loop (index-based)
        System.out.println("--- a. Simple For Loop ---");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Index " + i + ": " + numbers.get(i));
        }

        // b. Enhanced for loop (for-each)
        System.out.println("\n--- b. Enhanced For-Each Loop ---");
        for (Integer num : numbers) {
            System.out.println("Value: " + num);
        }

        // c. While loop with an Iterator
        System.out.println("\n--- c. While Loop with Iterator ---");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            System.out.println("Iterator Value: " + val);
        }
    }
}
