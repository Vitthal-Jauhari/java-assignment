// Write a program to search for an element in a sorted array using the binary search algorithm

import java.util.Scanner;

public class binary_search {
    public static void main(String[] args) {
        int[] arr = {5, 12, 19, 23, 34, 45, 56};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (result != -1) {
            System.out.println(key + " found at index " + result);
        } else {
            System.out.println(key + " not found in the array");
        }
        sc.close();
    }
}
