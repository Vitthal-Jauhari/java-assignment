// Write a program to find the largest and smallest numbers in an array.

import java.util.Scanner;
public class largest_smallest_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int largest = arr[0];
        int smallest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("Largest number in the array: " + largest);
        System.out.println("Smallest number in the array: " + smallest);
    }
}