// Write a program to demonstrate operator precedence in Java

public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 10, b = 5, c = 2;

        int result1 = a + b * c; // multiplication before addition
        System.out.println("a + b * c = " + result1);

        int result2 = (a + b) * c; // parentheses override precedence
        System.out.println("(a + b) * c = " + result2);

        int result3 = a % b + c * 2;
        System.out.println("a % b + c * 2 = " + result3);

        boolean result4 = a > b && b > c || a < c;
        System.out.println("a > b && b > c || a < c = " + result4);
    }
}
