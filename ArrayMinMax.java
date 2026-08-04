// Write a program to find the largest and smallest numbers in an array

public class ArrayMinMax {
    public static void main(String[] args) {
        int[] arr = {23, 45, 12, 89, 5, 67};

        int largest = arr[0];
        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);
    }
}
