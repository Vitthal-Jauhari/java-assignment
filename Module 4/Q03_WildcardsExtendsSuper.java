// Q03: Demonstrates ? extends T (Producer / covariance) and ? super T (Consumer / contravariance) - PECS.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q03_WildcardsExtendsSuper {

    // Producer Extends: read-only from source (produces T)
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Consumer Super: write-only to destination (consumes T)
    public static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 3; i++) {
            list.add(i * 10);
        }
    }

    public static void main(String[] args) {
        // Demonstration of ? extends Number
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Sum of Integers (? extends Number): " + sumOfList(intList));
        System.out.println("Sum of Doubles  (? extends Number): " + sumOfList(doubleList));

        // Demonstration of ? super Integer
        List<Number> numList = new ArrayList<>();
        addIntegers(numList);
        System.out.println("Numbers after adding integers (? super Integer): " + numList);

        List<Object> objList = new ArrayList<>();
        addIntegers(objList);
        System.out.println("Objects after adding integers (? super Integer): " + objList);
    }
}
