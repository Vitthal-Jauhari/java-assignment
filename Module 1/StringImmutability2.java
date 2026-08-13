// Write a program to demonstrate the immutability of the String class

public class StringImmutability2 {
    public static void main(String[] args) {
        String original = "Java";
        String modified = original.toUpperCase();

        System.out.println("Original: " + original); // stays "Java"
        System.out.println("Modified: " + modified);

        // Each string operation creates a new object instead of changing the old one
        System.out.println("original == modified: " + (original == modified));
    }
}
