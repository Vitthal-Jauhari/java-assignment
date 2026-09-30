// Q07: Generic class MinMaxFinder<T extends Comparable<T>> finding min and max elements in a List.

import java.util.Arrays;
import java.util.List;

class MinMaxFinder<T extends Comparable<T>> {
    private final List<T> list;

    public MinMaxFinder(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty.");
        }
        this.list = list;
    }

    public T findMin() {
        T min = list.get(0);
        for (T item : list) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    public T findMax() {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}

public class Q07_MinMaxFinder {
    public static void main(String[] args) {
        // Integer demonstration
        List<Integer> numbers = Arrays.asList(45, 12, 89, 3, 67, 99, 24);
        MinMaxFinder<Integer> intFinder = new MinMaxFinder<>(numbers);
        System.out.println("Numbers: " + numbers);
        System.out.println("Minimum: " + intFinder.findMin());
        System.out.println("Maximum: " + intFinder.findMax());

        // String demonstration
        List<String> fruits = Arrays.asList("Mango", "Apple", "Orange", "Banana", "Pineapple");
        MinMaxFinder<String> strFinder = new MinMaxFinder<>(fruits);
        System.out.println("\nFruits: " + fruits);
        System.out.println("Minimum: " + strFinder.findMin());
        System.out.println("Maximum: " + strFinder.findMax());
    }
}
