// Create a program to show the difference between == and equals() for string comparison

public class StringEqualsVsDoubleEqual {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        // s1 and s2 refer to the same object in the string pool
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));

        // s3 is a new object, so == compares references
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}
