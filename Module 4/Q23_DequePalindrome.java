// Q23: Check if a string is a palindrome using a Deque.

import java.util.ArrayDeque;
import java.util.Deque;

public class Q23_DequePalindrome {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        // Clean string: remove non-alphanumeric and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < cleaned.length(); i++) {
            deque.addLast(cleaned.charAt(i));
        }

        // Compare characters from both ends until 0 or 1 element remains
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char back = deque.removeLast();
            if (front != back) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testStrings = {
            "radar",
            "Madam, I'm Adam",
            "racecar",
            "hello",
            "Was it a car or a cat I saw?",
            "java"
        };

        System.out.println("Palindrome Verification using Deque:");
        System.out.println("------------------------------------");
        for (String str : testStrings) {
            System.out.printf("%-32s -> %s%n", "\"" + str + "\"", isPalindrome(str) ? "PALINDROME" : "NOT A PALINDROME");
        }
    }
}
