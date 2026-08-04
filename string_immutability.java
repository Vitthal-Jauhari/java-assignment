// WAP to demonstrate the immutability of the String class

public class string_immutability {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;

        s1 = s1.concat(" World");

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2); // s2 remains unchanged, proving immutability

        System.out.println("s1 == s2: " + (s1 == s2));
    }
}
