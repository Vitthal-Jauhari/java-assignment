// Implement a program to reverse the elements of an array

public class array_reverse {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.print("Reversed array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
