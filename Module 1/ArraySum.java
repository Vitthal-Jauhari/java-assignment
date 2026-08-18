// Write a program to find the sum of all elements in an array

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = { 12, 25, 8, 19, 34, 7 };
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of array elements: " + sum);
    }
}
