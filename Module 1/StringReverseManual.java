// Write a program to reverse a string without using built-in methods

import java.util.Scanner;

public class StringReverseManual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed = reversed + chars[i];
        }

        System.out.println("Reversed string: " + reversed);
        sc.close();
    }
}
