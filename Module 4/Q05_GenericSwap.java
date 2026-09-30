// Q05: Generic method swapElements to swap two elements in an array.

import java.util.Arrays;

public class Q05_GenericSwap {

    public static <T> void swapElements(T[] array, int i, int j) {
        if (i < 0 || i >= array.length || j < 0 || j >= array.length) {
            throw new IndexOutOfBoundsException("Invalid array indices provided for swapping.");
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // Swapping Integers
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println("Before swap (Integers): " + Arrays.toString(intArr));
        swapElements(intArr, 1, 3);
        System.out.println("After swap  (Integers): " + Arrays.toString(intArr));

        // Swapping Strings
        String[] strArr = {"Apple", "Banana", "Cherry", "Date"};
        System.out.println("\nBefore swap (Strings): " + Arrays.toString(strArr));
        swapElements(strArr, 0, 2);
        System.out.println("After swap  (Strings): " + Arrays.toString(strArr));
    }
}
