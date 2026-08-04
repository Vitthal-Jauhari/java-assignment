// Write a program to remove duplicate elements from an array

public class array_remove_duplicates {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 40, 50, 30};

        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int k = 0; k < j; k++) {
                if (temp[k] == arr[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[j] = arr[i];
                j++;
            }
        }

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < j; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}
