// Implement a program to count the frequency of characters in a string

import java.util.Scanner;

public class char_frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " : " + freq[i]);
            }
        }
        sc.close();
    }
}
