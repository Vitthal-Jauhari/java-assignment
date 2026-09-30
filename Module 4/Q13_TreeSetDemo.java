// Q13: TreeSet of integers performing:
// a. Add elements
// b. Find smallest (first) and largest (last) elements
// c. Remove a specific element

import java.util.TreeSet;

public class Q13_TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        // a. Add elements (in arbitrary order)
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(3);
        numbers.add(67);
        numbers.add(24);

        System.out.println("TreeSet (automatically sorted in natural order): " + numbers);

        // b. Find smallest and largest elements
        System.out.println("Smallest element (first()): " + numbers.first());
        System.out.println("Largest element  (last()) : " + numbers.last());

        // c. Remove a specific element
        int toRemove = 45;
        boolean removed = numbers.remove(toRemove);
        System.out.println("Removed element " + toRemove + ": " + removed);
        System.out.println("TreeSet after removal: " + numbers);
    }
}
