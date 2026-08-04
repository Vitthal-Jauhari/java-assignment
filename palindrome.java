// Write a program to check if a given string or number is a palindrome

import java.util.Scanner;

public class palindrome {
    static boolean isPalindromeString(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeNumber(int num) {
        int original = num;
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();
        if (isPalindromeString(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (isPalindromeNumber(num)) {
            System.out.println(num + " is a palindrome");
        } else {
            System.out.println(num + " is not a palindrome");
        }
        sc.close();
    }
}
