// Q10: Storing strings in ArrayList and performing:
// a. Add elements
// b. Remove by value and index
// c. Replace at specific index
// d. Print after each operation

import java.util.ArrayList;
import java.util.List;

public class Q10_ArrayListDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // a. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        System.out.println("After initial additions: " + fruits);

        // b1. Remove an element by value
        fruits.remove("Banana");
        System.out.println("After removing 'Banana' by value: " + fruits);

        // b2. Remove an element by index
        fruits.remove(1); // removes element at index 1 ("Cherry")
        System.out.println("After removing element at index 1: " + fruits);

        // c. Replace an element at a specific index
        fruits.set(0, "Apricot"); // replaces "Apple" with "Apricot"
        System.out.println("After replacing index 0 with 'Apricot': " + fruits);
    }
}
