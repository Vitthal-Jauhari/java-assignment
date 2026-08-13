// Implement a program to perform bitwise operations in Java

public class BitwiseOps {
    public static void main(String[] args) {
        int a = 12; // 1100
        int b = 10; // 1010

        System.out.println("a & b: " + (a & b));
        System.out.println("a | b: " + (a | b));
        System.out.println("a ^ b: " + (a ^ b));
        System.out.println("~a: " + (~a));
        System.out.println("a << 2: " + (a << 2));
        System.out.println("a >> 2: " + (a >> 2));
    }
}
